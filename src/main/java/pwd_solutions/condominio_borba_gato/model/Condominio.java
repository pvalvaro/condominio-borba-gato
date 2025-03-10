package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_CONDOMINIOS")
public class Condominio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String telefone;
}
