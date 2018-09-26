FROM docker.nexus.gpchatbot.archi-lab.io/chatbot/core:latest
#workdir
COPY ./config ./config
COPY ./stories ./stories