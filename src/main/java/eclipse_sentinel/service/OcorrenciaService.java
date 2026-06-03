package eclipse_sentinel.service;

import eclipse_sentinel.entity.Ocorrencia;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    public List<Ocorrencia> listarTodos() {
        return repository.findAll();
    }

    public Ocorrencia buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ocorrência não encontrada"));
    }

    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return repository.save(ocorrencia);
    }

    public Ocorrencia atualizar(Long id, Ocorrencia ocorrencia) {

        Ocorrencia existente = buscarPorId(id);

        existente.setDescricao(ocorrencia.getDescricao());
        existente.setImagemUrl(ocorrencia.getImagemUrl());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}