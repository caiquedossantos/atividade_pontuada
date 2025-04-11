package atividade.aula.model; // Pacote onde a classe está localizada

// Importações para JPA e validações
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity // Define que essa classe é uma entidade JPA (vai virar uma tabela no banco)
public class Funcionario {

    @Id // Define o campo 'id' como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco
    private long id;

    @NotBlank(message = "Não deve ser vazio") // Validação: campo obrigatório e não pode ser só espaços
    private String nome;

    @NotBlank(message = "Não deve ser vazio")
    private String cpf;

    @NotBlank(message = "Não deve ser vazio")
    private String dataNascimento;

    @Enumerated(EnumType.STRING) // Salva o nome do enum no banco
    private Sexo sexo;

    @Enumerated(EnumType.STRING) // Salva o nome do enum no banco
    private Setor setor;

    @Enumerated(EnumType.STRING) // Salva o nome do enum no banco
    private EstadoCivil estadoCivil;

    @NotNull // Validação: não pode ser nulo
    private double salario;

    @NotBlank(message = "Não deve ser vazio")
    private String email;

    @OneToOne(cascade = CascadeType.ALL) // Associação  com Endereco, com cascade total
    private Endereco endereco;

    // Construtor padrão necessário para o JPA
    public Funcionario() {
    }

    // Construtor completo com todos os atributos
    public Funcionario(long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor, EstadoCivil estadoCivil, double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters e setters para acessar e atualizar os atributos

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
