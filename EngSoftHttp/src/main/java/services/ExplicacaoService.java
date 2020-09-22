package services;

import models.Explicacao;
import models.MapperSingleton;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExplicacaoService {

    private RestTemplate restTemplate=new RestTemplate();

    public ResponseEntity<Explicacao> addExplicacao(Explicacao explicacao, String faculdadeName){
        String port= MapperSingleton.getInstance().getPort(faculdadeName);
        if(port!=null){
            ResponseEntity<Explicacao> explicacaoResponseEntity=restTemplate.postForEntity("http://127.0.0.1:"+port+"/explicacao",explicacao, Explicacao.class);
            System.out.println(explicacaoResponseEntity);
            return explicacaoResponseEntity;
        }
        return ResponseEntity.badRequest().build();
    }
}
