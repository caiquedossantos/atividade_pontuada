package atividade.aula.repository;

// Importa a entidade Endereco e a interface JpaRepository
import atividade.aula.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface responsável por acessar os dados da entidade Endereco
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
