package services;

import models.Explicador;
import models.MapperSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;



@Service
public class ExplicadorService {

    private RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public ExplicadorService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public ResponseEntity<Explicador> addExplicadorToFaculdade(Explicador explicador, String faculdadeName){
        String port= MapperSingleton.getInstance().getPort(faculdadeName);
        if(port!=null){
            ResponseEntity<Explicador> explicadorResponse=restTemplate.postForEntity("http://localhost:"+port+"/explicador",explicador, Explicador.class);
            System.out.println(explicadorResponse);
            return explicadorResponse;
        }
        return ResponseEntity.badRequest().build();

    }

    public ResponseEntity<Explicador> addCursoToExplicador(Explicador explicador, String faculdadeName, String cursoName){
        //this.logger.info("Received a put request");
        String port = MapperSingleton.getInstance().getPort(faculdadeName);
        if(port!=null){
            HttpEntity<Explicador> explicadorHttpEntity = new HttpEntity<>(explicador);
            ResponseEntity<Explicador> explicadorResponseEntity = restTemplate.exchange("http://localhost:" + port + "/explicador/"+cursoName, HttpMethod.PUT, explicadorHttpEntity, Explicador.class);
            System.out.println(explicadorHttpEntity);
            return explicadorResponseEntity;
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Explicador> modifyDisponibilidade(Explicador explicador){
        String port = MapperSingleton.getInstance().getPort(explicador.getCurso().getFaculdade().getName());
        if(port!=null){
            HttpEntity<Explicador> explicadorHttpEntity = new HttpEntity<>(explicador);
            ResponseEntity<Explicador> explicadorResponseEntity = restTemplate.exchange("http://localhost:" + port + "/explicador", HttpMethod.PUT, explicadorHttpEntity, Explicador.class);
            System.out.println(explicadorHttpEntity);
            return explicadorResponseEntity;
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Iterable> searchExplicadores(Map<String,String> query){
        ResponseEntity<Iterable> explicadorResponseEntity = restTemplate.getForEntity("http://localhost:8081/explicador"+"/"+query, Iterable.class);
        System.out.println(explicadorResponseEntity);
        return explicadorResponseEntity;
    }
/*
    public ResponseEntity<Explicador> searchExplicadorByName(String universidade, String explicador){
        String port = MapperSingleton.getInstance().getPort(universidade);
        if(port!=null){
            ResponseEntity<Explicador> explicadorResponseEntity = restTemplate.getForEntity("http://localhost:"+port+"/explicador"+"/"+explicador, Explicador.class);
            System.out.println(explicadorResponseEntity);
            return explicadorResponseEntity;
        }
        return ResponseEntity.badRequest().build();
    }
 */

    public ResponseEntity<List> searchExplicadoresInUniversidade(Map<String,String> query, String universidade){
        String port = MapperSingleton.getInstance().getPort(universidade);
        if(port!=null){
            ResponseEntity<List> explicadorResponseEntity=restTemplate.getForEntity("http://localhost:" + port + "/explicador"+"/"+query, List.class);
            System.out.println(explicadorResponseEntity);
            return explicadorResponseEntity;
        }
        return ResponseEntity.badRequest().build();
    }


}
