package application.kafka.stream;

import application.Constants;
import application.entity.Client;
import application.kafka.stream.intf.ClientStreamsBinding;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;

import java.util.Arrays;

@EnableBinding(ClientStreamsBinding.class)
public class ClientConsumeStreamService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InteractiveQueryService interactiveQueryService;


    @StreamListener
    public void process(@Input (Constants.KAFKA_TOPIC)KStream<String, Client> clients, String id) {
//        KGroupedStream<String, String> groupedByWord = clients
//                .flatMapValues(client -> Arrays.asList())
//                .groupBy((key, client) -> client, Grouped.with(stringSerde, stringSerde));
    }

}
