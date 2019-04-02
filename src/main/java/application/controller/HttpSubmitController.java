package application.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.dao.ClientRepository;
import application.entity.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import application.entity.RawData;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class HttpSubmitController {

    private static final Logger log = LoggerFactory.getLogger(HttpSubmitController.class);

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/submit")
    public String submitForm(Model model) {
        model.addAttribute("rawdata", new RawData());

        return "submit";
    }

    @PostMapping("/submit")
    public String submitAccept(@ModelAttribute RawData submit) throws IOException {
        System.out.println(persist(submit));

        return "result";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Client> getAllClients() {
        Iterable<Client> all = clientRepository.findAll();
        all.forEach(client -> log.info(client.toString()));

        return all;
    }

    private String persist(@ModelAttribute RawData submit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Client> mapType = new TypeReference<Client>() {
        };
        Client client = mapper.readValue(submit.getContent(), mapType);
        clientRepository.save(client);

        return client.toString();
    }

}
