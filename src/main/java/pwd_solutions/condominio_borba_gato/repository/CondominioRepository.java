package pwd_solutions.condominio_borba_gato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwd_solutions.condominio_borba_gato.model.Condominio;

import java.util.Optional;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {
    boolean existsByCnpj(String cnpj);

    Optional<Condominio> findByCnpj(String cnpj);
}
