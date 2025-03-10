package pwd_solutions.condominio_borba_gato.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_SERVICOS")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Tecnico tecnico;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataExecucao;

    @ManyToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    private Condominio condominio;
}
