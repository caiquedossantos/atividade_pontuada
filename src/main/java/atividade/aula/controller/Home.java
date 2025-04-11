package atividade.aula.controller;

// Importa as anotações para criar um controller REST e mapear métodos HTTP
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Define que essa classe é um controller REST (responde com dados, não com páginas HTML)
@RestController
public class Home {

    // Mapeia o endpoint raiz "/" para o método abaixo
    @GetMapping("/")
    public String welcome() {
        // Retorna uma mensagem de boas vindas ao acessar http://localhost:8080/
        return "Bem-vindo !";
    }

    // Mapeia o endpoint "/dev" para o método abaixo
    @GetMapping("/dev")
    public String nomeDesenvolvedor() {
        // Retorna o nome do desenvolvedor ao acessar http://localhost:8080/dev
        return "Dev: Caique dos Santos";
    }
}
