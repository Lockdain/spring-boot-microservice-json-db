package application.controller;

import application.kafka.Producer;
import application.model.RawData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Objects;

@Controller
public class KafkaController {

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/submitkafka")
    public String submitForm(Model model) {
        model.addAttribute("rawdata", new RawData());

        return "submitKafka";
    }

    @PostMapping("/submitKafka")
    public String submitAccept(@ModelAttribute RawData submit) throws IOException {
        if ("".equals(submit.getContent()) || Objects.isNull(submit.getContent())) {
            throw new IllegalArgumentException("The provided JSON string is empty!");
        }
        producer.sendMessage("test");
        return "resultSubmit";
    }
}
