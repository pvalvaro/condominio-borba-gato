package pwd_solutions.condominio_borba_gato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwd_solutions.condominio_borba_gato.dto.FuncionarioDto;
import pwd_solutions.condominio_borba_gato.model.Condominio;
import pwd_solutions.condominio_borba_gato.model.Funcionario;
import pwd_solutions.condominio_borba_gato.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean existsByCpf(String cpf) {
        return funcionarioRepository.existsByCpf(cpf);
    }

    public Object incluirFuncionario(FuncionarioDto funcionarioDto, Optional<Condominio> condominio) {
        var novoFuncionario = new Funcionario();
        novoFuncionario.setCargo(funcionarioDto.cargo());
        novoFuncionario.setCpf(funcionarioDto.cpf());
        novoFuncionario.setNome(funcionarioDto.nome());
        novoFuncionario.setSalario(funcionarioDto.salario());
        novoFuncionario.setCondominio(condominio.get());
        novoFuncionario.setDataContratacao(funcionarioDto.dataContratacao());
        return funcionarioRepository.save(novoFuncionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }
}
