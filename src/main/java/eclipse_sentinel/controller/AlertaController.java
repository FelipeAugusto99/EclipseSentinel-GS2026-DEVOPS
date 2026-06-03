package eclipse_sentinel.controller;

import eclipse_sentinel.entity.Alerta;
import eclipse_sentinel.service.AlertaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService service;

    @GetMapping
    public ResponseEntity<List<Alerta>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Alerta> criar(@RequestBody Alerta alerta) {
        return ResponseEntity.ok(service.salvar(alerta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(
            @PathVariable Long id,
            @RequestBody Alerta alerta) {

        return ResponseEntity.ok(service.atualizar(id, alerta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}