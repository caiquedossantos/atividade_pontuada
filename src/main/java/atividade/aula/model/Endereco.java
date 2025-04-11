package atividade.aula.model; // Define o pacote onde a classe está localizada

// Importações necessárias para a entidade e validação
import jakarta.persistence.Entity; // Marca a classe como uma entidade JPA (tabela no banco de dados)
import jakarta.persistence.GeneratedValue; // Para gerar automaticamente o ID
import jakarta.persistence.GenerationType; // Define o tipo de geração do ID
import jakarta.persistence.Id; // Indica o campo que é chave primária
import jakarta.validation.constraints.NotBlank; // Validação para garantir que o campo não seja vazio

@Entity // Anotação que transforma a classe em uma entidade JPA
public class Endereco {

    @Id // Define que esse campo será a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID será gerado automaticamente pelo banco
    private long id;

    // Os campos abaixo não podem ser vazios. Se estiverem vazios, geram erro de validação.
    @NotBlank(message = "Não deve ser vazio")
    private String logradouro;

    @NotBlank(message = "Não deve ser vazio")
    private String numero;

    @NotBlank(message = "Não deve ser vazio")
    private String complemento;

    @NotBlank(message = "Não deve ser vazio")
    private String cidade;

    // Construtor vazio necessário para o JPA
    public Endereco() {
    }

    // Construtor com todos os campos
    public Endereco(long id, String logradouro, String numero, String complemento, String cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    // Métodos getters e setters para acessar/atualizar os campos da classe
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
