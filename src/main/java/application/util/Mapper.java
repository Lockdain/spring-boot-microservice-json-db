package application.util;

import application.entity.Client;
import application.model.RawData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.util.Objects;

public class Mapper {

    /**
     * Maps input JSON to Client class
     *
     * @param submit
     * @return
     * @throws IOException
     */
    public static Client mapClient(@ModelAttribute RawData submit) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Client> mapType = new TypeReference<Client>() {
        };

        return mapper.readValue(submit.getContent(), mapType);
    }

    /**
     * Serializes Client to String
     *
     * @param client
     * @return
     * @throws JsonProcessingException
     */
    public static String serialize(Client client) throws JsonProcessingException {
        if (Objects.isNull(client)) {
            throw new IllegalArgumentException("Client is null");
        }
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(client);
    }
}
