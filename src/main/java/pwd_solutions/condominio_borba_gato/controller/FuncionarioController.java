package pwd_solutions.condominio_borba_gato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwd_solutions.condominio_borba_gato.dto.FuncionarioDto;
import pwd_solutions.condominio_borba_gato.model.Condominio;
import pwd_solutions.condominio_borba_gato.model.Funcionario;
import pwd_solutions.condominio_borba_gato.service.CondominioService;
import pwd_solutions.condominio_borba_gato.service.FuncionarioService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/condominio/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CondominioService condominioService;
    public FuncionarioController(FuncionarioService funcionarioService, CondominioService condominioService) {
        this.funcionarioService = funcionarioService;
        this.condominioService = condominioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> incluirFuncionario(@RequestBody FuncionarioDto funcionarioDto) {
        if(funcionarioService.existsByCpf(funcionarioDto.cpf())) return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já cadastrado");
        else {
            Optional<Condominio> condominio = condominioService.findByCnpj(funcionarioDto.cnpj());
            if(condominio.isPresent()) return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.incluirFuncionario(funcionarioDto, condominio));
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Condomínio não cadastrado");
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listarCondominios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        return funcionarios.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(funcionarios);
    }
}
