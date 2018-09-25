# Model-Trainer for Core
Trainiert ein Modell für Rasa-Core, packt diese in ein zip und schickt das ganze an einen server, der das Modell bereitstellt.

## Docker
Für die Verwendung in Docker sind folgende Befehle anzuwenden:
```bash
docker build -t chatbot-model-trainer .
```
```bash
docker-compose -f ./docker/docker-compose.yaml up  
```
Nach beendigung des Trainings schickt der Container einen Post request mit dem Modell an  http://gpb_chatbot-model-server_1:8000/models/core
