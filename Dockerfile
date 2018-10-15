FROM docker.nexus.gpchatbot.archi-lab.io/chatbot/core:latest
# copies config and stories to the image
COPY ./config ./config
COPY ./stories ./stories