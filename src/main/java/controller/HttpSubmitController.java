package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import entity.ClientId;
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
        mapToDb(submit);
        return "result";
    }

    public void mapToDb(@ModelAttribute RawData submit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<ClientId> mapType = new TypeReference<ClientId>(){};
        ClientId client = mapper.readValue(submit.getContent(), mapType);
        // clientRepository.save(client);
    }

}
