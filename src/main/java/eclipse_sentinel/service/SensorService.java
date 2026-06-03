package eclipse_sentinel.service;

import eclipse_sentinel.entity.Sensor;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository repository;

    public List<Sensor> listarTodos() {
        return repository.findAll();
    }

    public Sensor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado"));
    }

    public Sensor salvar(Sensor sensor) {
        return repository.save(sensor);
    }

    public Sensor atualizar(Long id, Sensor sensor) {

        Sensor existente = buscarPorId(id);

        existente.setTipoSensor(sensor.getTipoSensor());
        existente.setStatusSensor(sensor.getStatusSensor());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}