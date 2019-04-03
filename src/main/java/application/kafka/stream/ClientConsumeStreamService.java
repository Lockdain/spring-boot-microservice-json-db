package application.kafka.stream;

import application.entity.Client;
import application.kafka.stream.intf.ClientStreams;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ClientStreams.class)
public class ClientConsumeStreamService {

 //   @StreamListener("input")
 //   public KStream<?, Client> process(KStream<?, String> input) {
      //  return
 //   }
}
