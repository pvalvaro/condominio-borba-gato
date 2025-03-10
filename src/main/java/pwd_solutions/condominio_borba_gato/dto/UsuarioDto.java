package pwd_solutions.condominio_borba_gato.dto;
public record UsuarioDto(String nome, String senha, String email, String telefone, boolean isProprietario, Integer apartamento,
                         String nomeProprietario, String matricula, String role) {
}
