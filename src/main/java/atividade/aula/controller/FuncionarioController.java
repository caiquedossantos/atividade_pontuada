package atividade.aula.controller;


import atividade.aula.model.Funcionario;
import atividade.aula.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public  FuncionarioController(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario cadastrado com sucesso.");
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario atualizado com sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        funcionarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionario exluído com sucesso.");
    }
}
