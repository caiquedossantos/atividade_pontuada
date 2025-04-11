package atividade.aula.controller;

import atividade.aula.AulaApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {


    public static void main(String[] args) {
        SpringApplication.run(AulaApplication.class, args);
    }

    @GetMapping("/")
    public String welcome() {
        return "Bem-vindo !";
    }

    @GetMapping("/dev")
    public String nomeDesenvolvedor() {
        return "Dev: Caique dos Santos";
    }


}
