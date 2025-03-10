package pwd_solutions.condominio_borba_gato.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwd_solutions.condominio_borba_gato.dto.UsuarioDto;
import pwd_solutions.condominio_borba_gato.model.Usuario;
import pwd_solutions.condominio_borba_gato.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("borba-gato")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody @Valid UsuarioDto usuarioDto){
        if(usuarioService.existsByEmail(usuarioDto.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Email já registrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrar(usuarioDto));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return !usuarios.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(usuarios) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/usuario/{nome}")
    public ResponseEntity<Object> getUsuario(@PathVariable(value = "nome") String nome){
        Optional<Usuario> usuario = usuarioService.getUsuario(nome);
        if(usuario.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(usuario);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuário não encontrado.");
    }

    @DeleteMapping("/excluir-usuario/{nome}")
    public ResponseEntity<Object> excluirUsuario(@PathVariable(value = "nome") String nome){
        Optional<Usuario> usuario = usuarioService.getUsuario(nome);
        if(usuario.isPresent()) {
            usuarioService.excluirUsuario(usuario.get());
            return ResponseEntity.status(HttpStatus.OK).body("Usuário excluído com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuário não encontrado.");
        }
    }
    /*@PutMapping("/alterar-usuario/{nome}")
    public ResponseEntity<Object> alterarUsuario(@PathVariable(value = "nome") String nome, @RequestBody @Valid UsuarioDto usuarioDto){
        Optional<Usuario> usuarioRecuperado = usuarioService.getUsuario(nome);
        if(usuarioRecuperado.isPresent()) {
            if(usuarioService.existsByEmail(usuarioDto.email())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Email já registrado");
            }
            Usuario usuario = usuarioRecuperado.get();
            usuarioService.alterarUsuario(usuario, usuarioDto);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuário não encontrado.");
        }
    }*/
}
