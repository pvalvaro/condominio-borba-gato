package pwd_solutions.condominio_borba_gato.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record FuncionarioDto (
        String nome,
        String cpf,
        String cargo,
        BigDecimal salario,
        LocalDate dataContratacao,
        String cnpj
) {
}
