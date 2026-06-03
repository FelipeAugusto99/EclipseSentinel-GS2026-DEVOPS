package eclipse_sentinel.service;

import eclipse_sentinel.entity.Area;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository repository;

    public List<Area> listarTodos() {
        return repository.findAll();
    }

    public Area buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Área não encontrada"));
    }

    public Area salvar(Area area) {
        return repository.save(area);
    }

    public Area atualizar(Long id, Area area) {

        Area existente = buscarPorId(id);

        existente.setNome(area.getNome());
        existente.setStatus(area.getStatus());
        existente.setNivelRisco(area.getNivelRisco());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}