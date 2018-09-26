# KFZ-Chatbot
Chatbot für die Domain kfz

## Docker
Bauen des images mit:
```bash
docker build -t docker.nexus.gpchatbot.archi-lab.io/chatbot/kfz-chatbot .
```

Das System kann in verschiedenen modi gestartet werden.  
*Lokal* - Trainiert mit der vorliegenden Domain und stellt das Modell über eine Schnittstelle bereit
```bash
 docker-compose -p gpb -f docker/docker-compose.yaml -f docker/docker-compose.local.yaml up -d
```
*trainer* - Trainiert mit der vorliegenden Domain und schickt das Modell an einen Server
```bash
 docker-compose -p gpb -f docker/docker-compose.yaml -f docker/docker-compose.trainer.yaml up -d
```
*interactive* - Trainiert mit der vorliegenden Domain und stellt diese als interaktiven Chatbot nach außen bereit
```bash
 docker-compose -p gpb -f docker/docker-compose.yaml -f docker/docker-compose.interactive.yaml up -d
```