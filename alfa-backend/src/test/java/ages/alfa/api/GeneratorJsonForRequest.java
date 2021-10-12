package ages.alfa.api;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.fixture.Fixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class GeneratorJsonForRequest {

    @SneakyThrows
    @Test
    void generate() {

        //TODO REMOVER, usado para gerar os requests aleatorios para o postman
        System.out.println(new ObjectMapper().writeValueAsString(Fixture.make(CreateTeacherRequest.builder()).build()));
    }
}