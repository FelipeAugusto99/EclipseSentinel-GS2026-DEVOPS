package eclipse_sentinel.controller;

import eclipse_sentinel.entity.Sensor;
import eclipse_sentinel.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService service;

    @GetMapping
    public ResponseEntity<List<Sensor>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sensor> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Sensor> criar(@RequestBody Sensor sensor) {
        return ResponseEntity.ok(service.salvar(sensor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sensor> atualizar(
            @PathVariable Long id,
            @RequestBody Sensor sensor) {

        return ResponseEntity.ok(service.atualizar(id, sensor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}