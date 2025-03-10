package pwd_solutions.condominio_borba_gato.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwd_solutions.condominio_borba_gato.dto.FuncionarioDto;
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

    public Object registrar(FuncionarioDto funcionarioDto) {
        var funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioDto, funcionario);
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionario(String nome) {
        return funcionarioRepository.findByNome(nome);
    }

    public void excluir(Funcionario funcionario) {
        funcionarioRepository.delete(funcionario);
    }
}
