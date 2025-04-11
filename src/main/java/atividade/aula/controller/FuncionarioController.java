package atividade.aula.controller;

// Importações dos pacotes do projeto e bibliotecas necessárias
import atividade.aula.model.Funcionario;
import atividade.aula.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que essa classe é um controller REST (retorna JSON, por exemplo)
@RequestMapping("/funcionarios") // Define a URL base para todos os endpoints: /funcionarios
public class FuncionarioController {

    private FuncionarioService funcionarioService; // Injeta o serviço responsável pela lógica

    // Construtor para injetar o serviço (via injeção de dependência)
    public FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping // Mapeia requisições GET para /funcionarios
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos(); // Retorna a lista de todos os funcionários
    }

    @PostMapping // Mapeia requisições POST para /funcionarios
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario); // Valida e salva o funcionário
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario cadastrado com sucesso."); // Retorna resposta 201
    }

    @PutMapping // Mapeia requisições PUT para /funcionarios
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario); // Valida e atualiza o funcionário
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario atualizado com sucesso."); // Também retorna 201
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /funcionarios/{id}
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id); // Exclui o funcionário com o ID informado
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario excluído com sucesso."); // Retorna 201
    }
}
