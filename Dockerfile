FROM rasa/rasa_core:0.12.0a2 as training
#Add training data to context
COPY . .
#install zip
RUN apt-get update \
    && apt-get install -y zip
#train dialog and zip it
ENTRYPOINT python ./src/train_dialog.py \
    && mkdir /output \
    && cd ./models/dialogue \
    && zip -r /output/model.zip ./* \
    && cd - \
    && curl -X POST -H "Content-Type: application/zip" -d /output/model.zip \
     http://gpb_chatbot-model-server_1:8000