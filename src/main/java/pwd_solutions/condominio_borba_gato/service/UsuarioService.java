package pwd_solutions.condominio_borba_gato.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwd_solutions.condominio_borba_gato.model.Usuario;
import pwd_solutions.condominio_borba_gato.dto.UsuarioDto;
import pwd_solutions.condominio_borba_gato.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Usuario registrar(UsuarioDto usuarioDto) {
        var novoUsuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, novoUsuario);
        return usuarioRepository.save(novoUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuario(String nome) {
        return usuarioRepository.findByNome(nome);
    }
    @Transactional
    public void excluirUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
    @Transactional
    public void alterarUsuario(Usuario usuario, UsuarioDto usuarioDto) {
        BeanUtils.copyProperties(usuarioDto, usuario);
        usuarioRepository.save(usuario);
    }
}

