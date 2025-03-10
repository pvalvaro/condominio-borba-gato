package pwd_solutions.condominio_borba_gato.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record FuncionarioDto(
        String nome,
        String telefone,
        String especialidade,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataInicio,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dataFim
) {}

