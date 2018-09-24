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
    && curl -X POST -F "file=@/output/model.zip;type=application/zip" \
     http://gpb_chatbot-model-server_1:8000/models/core