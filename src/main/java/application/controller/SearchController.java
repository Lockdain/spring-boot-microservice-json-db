package application.controller;

import application.dao.ClientRepository;
import application.entity.Client;
import application.model.ClientId;
import application.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Optional;

@Controller
public class SearchController {

    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/search")
    public String searchForm(Model model) {
        model.addAttribute("clientId", new ClientId());

        return "searchById";
    }

    @PostMapping("/search")
    public String searchAccept(@ModelAttribute ClientId clientId) throws IOException {
        Optional<Client> result = clientRepository.findById(clientId.getClientId());
        Client client = null;
        if (result.isPresent()) {
            client = result.get();
            log.info(result.get().toString());
        } else {
            log.info("Nothing is found");
        }

        String jsonString = Mapper.serialize(client);
        log.info("JSON: " + jsonString);
        clientId.setJson(jsonString);

        return "resultSearchById";
    }

}
