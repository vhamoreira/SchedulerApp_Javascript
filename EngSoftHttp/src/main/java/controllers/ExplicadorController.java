package controllers;

import models.Explicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.ExplicadorService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/explicador")
public class ExplicadorController {

    //private Logger logger= LoggerFactory.getLogger(this.getClass());

    private ExplicadorService explicadorService;

    @Autowired
    public ExplicadorController(ExplicadorService explicadorService){this.explicadorService=explicadorService;}


    @PostMapping(value="/{universidade}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> createExplicador(@RequestBody Explicador explicador, @PathVariable("universidade")String universidadeName){
        return this.explicadorService.addExplicadorToFaculdade(explicador, universidadeName);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> addDisponibilidade(@RequestBody Explicador explicador) {
        return this.explicadorService.modifyDisponibilidade(explicador);
    }

    @PutMapping(value="/{universidade}/{curso}", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Explicador> modifyExplicador(@RequestBody Explicador explicador, @PathVariable("universidade")String universidadeName, @PathVariable("curso")String cursoName){
        return this.explicadorService.addCursoToExplicador(explicador,universidadeName,cursoName);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable> searchExplicadores(@RequestParam Map<String,String> query){
        return this.explicadorService.searchExplicadores(query);
    }

    @GetMapping(value = "{universidade}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List> searchExplicadores(@RequestParam Map<String,String> query,@PathVariable("universidade")String universidadeName){
        return this.explicadorService.searchExplicadoresInUniversidade(query, universidadeName);
    }
}
