package atividade.aula.service;

import atividade.aula.model.Funcionario;
import atividade.aula.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw  new IllegalArgumentException(("Funcionario já cadastrado"));
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario){
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId()).
                orElseThrow(( )-> new IllegalArgumentException("Funcionario não encontrado"));

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

    public void excluir(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(( )-> new IllegalArgumentException("Funcionario não encontrado"));

        funcionarioRepository.deleteById(funcionario.getId());

    }
}
