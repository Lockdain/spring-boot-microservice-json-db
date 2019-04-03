package application.kafka.stream.intf;

import application.Constants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ClientStreams {

    @Input(Constants.INPUT)
    SubscribableChannel inboundClients();

    @Output(Constants.OUTPUT)
    MessageChannel outboundClients();
}
