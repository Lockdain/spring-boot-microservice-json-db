package application.kafka;

import application.Constants;
import application.entity.Client;
import application.util.Mapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Client client) throws JsonProcessingException {
        String message = Mapper.serialize(client);
        logger.info(String.format("#### -> Producing message -> %s", message));

        ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(Constants.KAFKA_TOPIC, String.valueOf(client.getClientId()), message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.warn("Unable to send message: " + message + " Error:" + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Message is sent with the offset of: " + result.getRecordMetadata().offset());
            }
        });
    }
}
