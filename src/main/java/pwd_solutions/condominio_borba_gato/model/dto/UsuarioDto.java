package pwd_solutions.condominio_borba_gato.model.dto;
public record UsuarioDto(String nome_completo, String senha, String email, String telefone, boolean isProprietario, String apartamento, String role) {
}
