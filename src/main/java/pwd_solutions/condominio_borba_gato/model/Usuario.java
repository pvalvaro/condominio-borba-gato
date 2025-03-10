package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;
@Entity
@Table(name = "TB_USUARIOS")
public class Usuario {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String telefone;
    @Column(nullable = false)
    private boolean isProprietario;
    @Column(nullable = false, unique = true)
    private Integer apartamento;
    @Column(nullable = false)
    private String nomeProprietario;
    @Column(nullable = true, unique = true)
    private String matricula;
    @Column(nullable = false)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isProprietario() {
        return isProprietario;
    }

    public void setProprietario(boolean proprietario) {
        isProprietario = proprietario;
    }

    public Integer getApartamento() {
        return apartamento;
    }

    public void setApartamento(Integer apartamento) {
        this.apartamento = apartamento;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
