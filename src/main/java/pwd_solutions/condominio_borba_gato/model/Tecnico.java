package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TECNICOS")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf; // Pode ser CNPJ para empresas

    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false)
    private String telefone;

    private String email;
}
