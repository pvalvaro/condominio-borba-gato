package pwd_solutions.condominio_borba_gato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "condominos")
public class Condomino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Apartamento> apartamentos;

    // Getters e Setters
}
