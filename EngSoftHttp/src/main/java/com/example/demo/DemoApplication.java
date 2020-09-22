package com.example.demo;

import controllers.ExplicadorController;
import models.Disponibilidade;
import models.Explicador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalTime;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
/*
        RestTemplate restTemplate=new RestTemplate();

        Explicador explicador=new Explicador("ABCD");

        ResponseEntity<Explicador> explicadorResponseEntity=restTemplate.postForEntity("http://localhost:8081/explicador",explicador, Explicador.class);
        System.out.println(explicadorResponseEntity);
        System.out.println(explicadorResponseEntity.getBody());

        Disponibilidade disponibilidade=new Disponibilidade();
        disponibilidade.setDia(DayOfWeek.WEDNESDAY);
        disponibilidade.setHoraIni(LocalTime.NOON.plusHours(6));
        disponibilidade.setHoraFim(LocalTime.NOON.plusHours(8));
        explicador.addDisponibilidade(disponibilidade);

        explicador.setName("Rui");
        HttpEntity<Explicador> explicadorHttpEntity = new HttpEntity<>(explicador);
        ResponseEntity<Explicador> explicadorResponseEntity2 = restTemplate.exchange("http://localhost:8081/explicador", HttpMethod.PUT, explicadorHttpEntity, Explicador.class);
        System.out.println(explicadorResponseEntity2);

 */

    }

}
