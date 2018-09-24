# Model-Trainer for Core
Trainiert ein Modell für Rasa-Core, packt diese in ein zip und schickt das ganze an einen server, der das Modell bereitstellt.

## Docker
Für die Verwendung in Docker sind folgende Befehle anzuwenden:
```bash
docker build -t chatbot-model-trainer .
```
```bash
docker run --rm --network=chatbot chatbot-model-trainer
```
