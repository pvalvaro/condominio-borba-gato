package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_APARTAMENTOS")
public class Apartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String bloco;

    @Column(nullable = false, unique = true)
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Condomino proprietario;

    @ManyToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;

}
