package eclipse_sentinel.service;

import eclipse_sentinel.entity.LeituraSensor;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.LeituraSensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeituraSensorService {

    private final LeituraSensorRepository repository;

    public List<LeituraSensor> listarTodos() {
        return repository.findAll();
    }

    public LeituraSensor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leitura não encontrada"));
    }

    public LeituraSensor salvar(LeituraSensor leitura) {
        return repository.save(leitura);
    }

    public LeituraSensor atualizar(Long id, LeituraSensor leitura) {

        LeituraSensor existente = buscarPorId(id);

        existente.setTemperatura(leitura.getTemperatura());
        existente.setUmidade(leitura.getUmidade());
        existente.setFumaca(leitura.getFumaca());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}