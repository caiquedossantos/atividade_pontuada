package atividade.aula.service;

// Importa a entidade Funcionario e o repositório correspondente
import atividade.aula.model.Funcionario;
import atividade.aula.repository.FuncionarioRepository;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

// Indica que essa classe é um componente de serviço do Spring
@Service
@Validated // Permite validações com @Valid dentro da classe
public class FuncionarioService {

    // Injeta o repositório de funcionários
    FuncionarioRepository funcionarioRepository;

    // Construtor para injeção de dependência
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    // Retorna uma lista com todos os funcionários cadastrados
    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    // Salva um novo funcionário, desde que o e-mail ainda não esteja cadastrado
    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new IllegalArgumentException("Funcionario já cadastrado"); // Evita duplicidade
        }
        return funcionarioRepository.save(funcionario); // Persiste no banco
    }

    // Atualiza os dados de um funcionário existente
    public Funcionario atualizar(@Valid Funcionario funcionario){
        // Busca o funcionário pelo ID e lança exceção se não encontrar
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        // Atualiza todos os campos manualmente
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionario);
    }

    // Exclui um funcionário a partir do ID
    public void excluir(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioRepository.deleteById(funcionario.getId()); // Remove do banco
    }
}
