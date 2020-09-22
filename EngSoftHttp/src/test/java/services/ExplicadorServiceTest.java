package services;

import models.Explicador;
import models.MapperSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = ExplicadorService.class)
class ExplicadorServiceTest {

    @Autowired
    private ExplicadorService explicadorService;

    @MockBean
    private RestTemplate restTemplate;

    @MockBean
    private MapperSingleton mapperSingleton;


    @Test
    void addExplicadorToFaculdade() {


        Explicador explicador=new Explicador("Rui");
        String faculdade="UFP";

        when(mapperSingleton.getPort(faculdade)).thenReturn("8080");
        when(this.restTemplate.postForEntity("http://127.0.0.1:8080/explicador",explicador, Explicador.class)).thenReturn(ResponseEntity.ok(explicador));

        ResponseEntity<Explicador> explicadorResponse=this.explicadorService.addExplicadorToFaculdade(explicador, faculdade);

        System.out.println(explicadorResponse);
        //assertTrue(explicadorResponse.getStatusCode().is2xxSuccessful());
        //assertNotNull(explicadorResponse.getBody());

    }

    @Test
    void addCursoToExplicador() {
    }

    @Test
    void modifyDisponibilidade() {
    }

    @Test
    void searchExplicadores() {
    }

    @Test
    void searchExplicadoresInUniversidade() {
    }
}