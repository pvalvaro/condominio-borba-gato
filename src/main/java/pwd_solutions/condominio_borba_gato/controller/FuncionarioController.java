package pwd_solutions.condominio_borba_gato.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwd_solutions.condominio_borba_gato.dto.FuncionarioDto;
import pwd_solutions.condominio_borba_gato.dto.UsuarioDto;
import pwd_solutions.condominio_borba_gato.model.Funcionario;
import pwd_solutions.condominio_borba_gato.model.Usuario;
import pwd_solutions.condominio_borba_gato.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("borba-gato/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @PostMapping("/registrar")
    public ResponseEntity<Object> registrar(@RequestBody @Valid FuncionarioDto funcionarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.registrar(funcionarioDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Funcionario>> getFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.getFuncionarios();
        return !funcionarios.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(funcionarios) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Object> getFuncionario(@PathVariable(value = "nome") String nome){
        Optional<Funcionario> funcionario = funcionarioService.getFuncionario(nome);
        if(funcionario.isPresent()) return ResponseEntity.status(HttpStatus.OK).body(funcionario);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
    }

    @DeleteMapping("/excluir/{nome}")
    public ResponseEntity<Object> excluir(@PathVariable(value = "nome") String nome){
        Optional<Funcionario> funcionario = funcionarioService.getFuncionario(nome);
        if(funcionario.isPresent()) {
            funcionarioService.excluir(funcionario.get());
            return ResponseEntity.status(HttpStatus.OK).body("Funcionário excluído com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
        }
    }
    /*@PutMapping("/alterar/{nome}")
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
