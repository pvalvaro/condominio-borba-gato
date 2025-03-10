package pwd_solutions.condominio_borba_gato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pwd_solutions.condominio_borba_gato.model.Funcionario;
import pwd_solutions.condominio_borba_gato.model.Usuario;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query(value = "SELECT * FROM TB_FUNCIONARIOS funcionario WHERE UPPER(usuario.nome) LIKE CONCAT('%', UPPER(:nome), '%')", nativeQuery = true)
    Optional<Funcionario> findByNome(String nome);
}
