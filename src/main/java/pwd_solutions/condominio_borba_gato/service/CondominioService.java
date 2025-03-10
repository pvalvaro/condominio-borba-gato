package pwd_solutions.condominio_borba_gato.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwd_solutions.condominio_borba_gato.dto.CondominioDto;
import pwd_solutions.condominio_borba_gato.model.Condominio;
import pwd_solutions.condominio_borba_gato.repository.CondominioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioService{
    @Autowired
    private CondominioRepository condominioRepository;

    public CondominioService(CondominioRepository condominioRepository) {
        this.condominioRepository = condominioRepository;
    }
    public boolean existsByCnpj(String cnpj){
        return condominioRepository.existsByCnpj(cnpj);
    }
    public Optional<Condominio> findByCnpj(String cnpj) {
        return condominioRepository.findByCnpj(cnpj);
    }

    public Object incluirCondominio(CondominioDto condominioDto) {
        var novoCondominio = new Condominio();
        BeanUtils.copyProperties(condominioDto, novoCondominio);
        return condominioRepository.save(novoCondominio);
    }

    public List<Condominio> listarCondominios() {
        return condominioRepository.findAll();
    }
}
