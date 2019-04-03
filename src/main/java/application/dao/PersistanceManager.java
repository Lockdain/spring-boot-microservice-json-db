package application.dao;

import application.entity.Client;
import application.model.RawData;
import application.util.Mapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

public class PersistanceManager {

    /**
     * Persists client to a database
     *
     * @param clientRepository
     * @param submit
     * @return
     * @throws IOException
     */
    public static String persist(ClientRepository clientRepository, @ModelAttribute RawData submit) throws IOException {
        Client client = Mapper.mapClient(submit);
        clientRepository.save(client);

        return client.toString();
    }
}
