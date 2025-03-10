package pwd_solutions.condominio_borba_gato.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwd_solutions.condominio_borba_gato.model.Usuario;
import pwd_solutions.condominio_borba_gato.model.dto.UsuarioDto;
import pwd_solutions.condominio_borba_gato.service.UsuarioService;

@RestController
@RequestMapping("borba-gato")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrar(usuarioDto));
    }
}
