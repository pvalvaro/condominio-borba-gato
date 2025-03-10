package pwd_solutions.condominio_borba_gato.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwd_solutions.condominio_borba_gato.model.Usuario;
import pwd_solutions.condominio_borba_gato.model.dto.UsuarioDto;
import pwd_solutions.condominio_borba_gato.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario registrar(UsuarioDto usuarioDto) {
        var novoUsuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, novoUsuario);
        return usuarioRepository.save(novoUsuario);
    }
}

