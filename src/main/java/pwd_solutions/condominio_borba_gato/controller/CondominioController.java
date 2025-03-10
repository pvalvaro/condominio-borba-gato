package pwd_solutions.condominio_borba_gato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwd_solutions.condominio_borba_gato.dto.CondominioDto;
import pwd_solutions.condominio_borba_gato.model.Condominio;
import pwd_solutions.condominio_borba_gato.service.CondominioService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/condominio")
public class CondominioController {
    @Autowired
    private CondominioService condominioService;

    public CondominioController(CondominioService condominioService) {
        this.condominioService = condominioService;
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> incluirCondominio(@RequestBody CondominioDto condominioDto) {
       if(condominioService.existsByCnpj(condominioDto.cnpj())) return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CNPJ já cadastrado");
       else return ResponseEntity.status(HttpStatus.CREATED).body(condominioService.incluirCondominio(condominioDto));
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Condominio>> listarCondominios() {
        List<Condominio> condominios = condominioService.listarCondominios();
        return condominios.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(condominios);
    }
}
