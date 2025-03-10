package pwd_solutions.condominio_borba_gato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pwd_solutions.condominio_borba_gato.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM TB_USUARIOS usuario WHERE UPPER(usuario.nome) LIKE CONCAT('%', UPPER(:nome), '%')", nativeQuery = true)
    Optional<Usuario> findByNome(String nome);
}
