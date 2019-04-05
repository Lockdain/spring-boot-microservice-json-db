package application.kafka.stream.intf;

import application.Constants;
import application.entity.Client;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface ClientStreamsBinding {

    @Input(Constants.INPUT)
    KStream<String, Client> clientsIn();
}
