package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;
import pwd_solutions.condominio_borba_gato.enums.TipoDespesa;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_DESPESAS")
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoDespesa tipoDespesa;

    @ManyToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;

}
