package pwd_solutions.condominio_borba_gato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwd_solutions.condominio_borba_gato.model.Despesa;
@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}
