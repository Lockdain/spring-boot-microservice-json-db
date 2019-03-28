package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import entity.RawData;

import java.io.IOException;

@Controller
public class HttpSubmitController {

    // @Autowired
   // ClientRepository clientRepository;

    @GetMapping("/submit")
    public String submitForm(Model model) {
        model.addAttribute("rawdata", new RawData());
        return "submit";
    }

    @PostMapping("/submit")
    public String submitAccept(@ModelAttribute RawData submit) throws IOException {
        System.out.println(mapToDb(submit));
        submit.setJsonString(mapToDb(submit));
        return "result";
    }

    public String mapToDb(@ModelAttribute RawData submit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Client> mapType = new TypeReference<Client>(){};
        Client client = mapper.readValue(submit.getContent(), mapType);
        return client.toString();
        // clientRepository.save(client);
    }

}
