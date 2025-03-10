package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;
@Entity
@Table(name = "TB_USUARIOS")
public class Usuario {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(255) NOT NULL")
    private String nome_completo;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String telefone;
    @Column(nullable = false)
    private boolean isProprietario;
    @Column(nullable = false, unique = true)
    private String apartamento;
    @Column(nullable = false)
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
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

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
