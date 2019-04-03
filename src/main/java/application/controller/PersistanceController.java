package application.controller;

import application.dao.PersistanceManager;
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
import application.model.RawData;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Objects;

@Controller
public class PersistanceController {

    private static final Logger log = LoggerFactory.getLogger(PersistanceController.class);

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/submit")
    public String submitForm(Model model) {
        model.addAttribute("rawdata", new RawData());

        return "submit";
    }

    @PostMapping("/submit")
    public String submitAccept(@ModelAttribute RawData submit) throws IOException {
        if ("".equals(submit.getContent()) || Objects.isNull(submit.getContent())) {
            throw new IllegalArgumentException("The provided JSON string is empty!");
        }

        PersistanceManager.persist(clientRepository, submit);

        return "resultSubmit";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Client> getAllClients() {
        Iterable<Client> all = clientRepository.findAll();
        all.forEach(client -> log.info(client.toString()));

        return all;
    }

}
