package pwd_solutions.condominio_borba_gato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwd_solutions.condominio_borba_gato.model.Apartamento;
@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}
