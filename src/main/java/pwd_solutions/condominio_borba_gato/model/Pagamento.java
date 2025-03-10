package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;
import pwd_solutions.condominio_borba_gato.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PAGAMENTOS")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "condomino_id", nullable = false)
    private Condomino condomino;

    @ManyToOne
    @JoinColumn(name = "apartamento_id", nullable = false)
    private Apartamento apartamento;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    // Getters e Setters
}
