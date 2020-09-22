package controllers;

import models.Explicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import services.ExplicacaoService;

@Controller
@RequestMapping("/explicacao")
public class ExplicacaoController {

    private ExplicacaoService explicacaoService;

    @Autowired
    public ExplicacaoController(ExplicacaoService explicacaoService){this.explicacaoService=explicacaoService;}

    @PostMapping(value="/{universidade}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicacao> createExplicacao(@RequestBody Explicacao explicacao, @PathVariable("universidade")String universidadeName){
        return this.explicacaoService.addExplicacao(explicacao, universidadeName);
    }

}
