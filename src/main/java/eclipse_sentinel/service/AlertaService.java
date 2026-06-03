package eclipse_sentinel.service;

import eclipse_sentinel.entity.Alerta;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository repository;

    public List<Alerta> listarTodos() {
        return repository.findAll();
    }

    public Alerta buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alerta não encontrado"));
    }

    public Alerta salvar(Alerta alerta) {
        return repository.save(alerta);
    }

    public Alerta atualizar(Long id, Alerta alerta) {

        Alerta existente = buscarPorId(id);

        existente.setTipoAlerta(alerta.getTipoAlerta());
        existente.setSeveridade(alerta.getSeveridade());
        existente.setDescricao(alerta.getDescricao());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}