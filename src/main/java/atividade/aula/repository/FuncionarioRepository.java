package atividade.aula.repository;

// Importa a classe Funcionario e a interface JpaRepository do Spring Data JPA
import atividade.aula.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface que estende JpaRepository para fornecer operações de CRUD para a entidade Funcionario
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Método personalizado para buscar um funcionário pelo e-mail
    Optional<Funcionario> findByEmail(String email);

}
