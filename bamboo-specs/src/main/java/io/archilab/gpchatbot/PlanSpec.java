package io.archilab.gpchatbot;

import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.BambooKey;
import com.atlassian.bamboo.specs.api.builders.deployment.Deployment;
import com.atlassian.bamboo.specs.api.builders.deployment.Environment;
import com.atlassian.bamboo.specs.api.builders.deployment.ReleaseNaming;
import com.atlassian.bamboo.specs.api.builders.permission.DeploymentPermissions;
import com.atlassian.bamboo.specs.api.builders.permission.EnvironmentPermissions;
import com.atlassian.bamboo.specs.api.builders.permission.PermissionType;
import com.atlassian.bamboo.specs.api.builders.permission.Permissions;
import com.atlassian.bamboo.specs.api.builders.permission.PlanPermissions;
import com.atlassian.bamboo.specs.api.builders.plan.Job;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.plan.PlanIdentifier;
import com.atlassian.bamboo.specs.api.builders.plan.Stage;
import com.atlassian.bamboo.specs.api.builders.plan.artifact.Artifact;
import com.atlassian.bamboo.specs.api.builders.plan.branches.BranchCleanup;
import com.atlassian.bamboo.specs.api.builders.plan.branches.PlanBranchManagement;
import com.atlassian.bamboo.specs.api.builders.plan.configuration.ConcurrentBuilds;
import com.atlassian.bamboo.specs.api.builders.project.Project;
import com.atlassian.bamboo.specs.api.builders.requirement.Requirement;
import com.atlassian.bamboo.specs.builders.task.ArtifactDownloaderTask;
import com.atlassian.bamboo.specs.builders.task.CheckoutItem;
import com.atlassian.bamboo.specs.builders.task.CleanWorkingDirectoryTask;
import com.atlassian.bamboo.specs.builders.task.DockerBuildImageTask;
import com.atlassian.bamboo.specs.builders.task.DockerPushImageTask;
import com.atlassian.bamboo.specs.builders.task.DownloadItem;
import com.atlassian.bamboo.specs.builders.task.InjectVariablesTask;
import com.atlassian.bamboo.specs.builders.task.ScriptTask;
import com.atlassian.bamboo.specs.builders.task.VcsCheckoutTask;
import com.atlassian.bamboo.specs.builders.trigger.AfterSuccessfulBuildPlanTrigger;
import com.atlassian.bamboo.specs.builders.trigger.BitbucketServerTrigger;
import com.atlassian.bamboo.specs.model.task.InjectVariablesScope;
import com.atlassian.bamboo.specs.util.BambooServer;

@BambooSpec
public class PlanSpec {

  public Plan plan() {
    final Plan plan = new Plan(new Project()
        .key(new BambooKey("CHAT"))
        .name("Chatbot"),
        "kfz-chatbot",
        new BambooKey("kfz"))
        .pluginConfigurations(new ConcurrentBuilds()
            .useSystemWideDefault(false))
        .stages(new Stage("Default Stage")
            .jobs(new Job("Default Job",
                new BambooKey("JOB1"))
                .artifacts(new Artifact().name("docker-compose")
                    .copyPattern("docker-compose.yaml")
                    .location("./docker").shared(true).required(true))
                .tasks(new VcsCheckoutTask()
                        .description("Checkout the repository")
                        .checkoutItems(new CheckoutItem()
                            .defaultRepository()),
                    new ScriptTask().description(
                        "Create commit hash variable file")
                        .inlineBody("echo \"commit-hash=$(date +%s%N)\" > ./commit-hash"),
                    new InjectVariablesTask()
                        .description("Inject the commit hash variable")
                        .path("./commit-hash")
                        .namespace("inject")
                        .scope(InjectVariablesScope.RESULT),
                    .requirements(new Requirement(
                    "system.builder.command.nexus-cli"))))
        .linkedRepositories("kfz-chatbot (master)")
        .triggers(new BitbucketServerTrigger())
        .planBranchManagement(new PlanBranchManagement()
            .delete(new BranchCleanup())
            .notificationForCommitters());
    return plan;
  }

  public PlanPermissions planPermission() {
    final PlanPermissions planPermission = new PlanPermissions(new PlanIdentifier("CHAT", "kfz"))
        .permissions(new Permissions()
            .userPermissions("bamboo", PermissionType.EDIT, PermissionType.VIEW,
                PermissionType.ADMIN, PermissionType.CLONE, PermissionType.BUILD)
            .loggedInUserPermissions(PermissionType.VIEW)
            .anonymousUserPermissionView());
    return planPermission;
  }

  public Deployment deployment() {
    final Deployment deployment = new Deployment(new PlanIdentifier("CHAT", "kfz"),
        "kfz-chatbot-deployment")
        .releaseNaming(new ReleaseNaming("release-1")
            .autoIncrement(true))
        .environments(new Environment("Production")
            .tasks(new CleanWorkingDirectoryTask(),
                new ArtifactDownloaderTask()
                    .description("Download release contents")
                    .artifacts(new DownloadItem()
                        .allArtifacts(true)
                        .path("./artifacts")),
                new ScriptTask()
                    .description("Deploy Docker stack via docker-machine")
                    .inlineBody(
                        "eval $(docker-machine env gpchatbotprod)\ndocker stack deploy --with-registry-auth \\\n  -c ./artifacts/docker-compose.yaml \\\n  kfz-chatbot"))
            .triggers(new AfterSuccessfulBuildPlanTrigger()));
    return deployment;
  }

  public DeploymentPermissions deploymentPermission() {
    final DeploymentPermissions deploymentPermission = new DeploymentPermissions("kfz-chatbot-deployment")
        .permissions(new Permissions()
            .userPermissions("bamboo", PermissionType.EDIT, PermissionType.VIEW)
            .loggedInUserPermissions(PermissionType.VIEW)
            .anonymousUserPermissionView());
    return deploymentPermission;
  }

  public EnvironmentPermissions environmentPermission1() {
    final EnvironmentPermissions environmentPermission1 = new EnvironmentPermissions(
        "core-model-trainer-deployment")
        .environmentName("Production")
        .permissions(new Permissions()
            .userPermissions("bamboo", PermissionType.EDIT, PermissionType.VIEW,
                PermissionType.BUILD)
            .loggedInUserPermissions(PermissionType.VIEW)
            .anonymousUserPermissionView());
    return environmentPermission1;
  }

  public static void main(String... argv) {
    //By default credentials are read from the '.credentials' file.
    BambooServer bambooServer = new BambooServer("https://bamboo.gpchatbot.archi-lab.io");
    final PlanSpec planSpec = new PlanSpec();

    final Plan plan = planSpec.plan();
    bambooServer.publish(plan);

    final PlanPermissions planPermission = planSpec.planPermission();
    bambooServer.publish(planPermission);

    final Deployment deployment = planSpec.deployment();
    bambooServer.publish(deployment);

    final DeploymentPermissions deploymentPermission = planSpec.deploymentPermission();
    bambooServer.publish(deploymentPermission);

    final EnvironmentPermissions environmentPermission1 = planSpec.environmentPermission1();
    bambooServer.publish(environmentPermission1);
  }
}
