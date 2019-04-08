package application.kafka.stream;

import application.entity.Client;
import application.kafka.stream.intf.ClientStreamsBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

//@Service
public class ClientProduceStreamService {

    private final static Logger logger = LoggerFactory.getLogger(ClientProduceStreamService.class);

    private final ClientStreamsBinding clientStreamsBinding;

    public ClientProduceStreamService(ClientStreamsBinding clientStreamsBinding) {
        this.clientStreamsBinding = clientStreamsBinding;
    }

    public void sendClient(final Client client) {
        logger.info("Sending client {}", client);

//        MessageChannel messageChannel = clientStreamsBinding.outboundClients();
//        messageChannel.send(MessageBuilder
//                .withPayload(client)
//                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                .build());
    }
}
