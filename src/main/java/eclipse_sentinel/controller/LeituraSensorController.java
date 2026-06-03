package eclipse_sentinel.controller;

import eclipse_sentinel.entity.LeituraSensor;
import eclipse_sentinel.service.LeituraSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leituras")
@RequiredArgsConstructor
public class LeituraSensorController {

    private final LeituraSensorService service;

    @GetMapping
    public ResponseEntity<List<LeituraSensor>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraSensor> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<LeituraSensor> criar(@RequestBody LeituraSensor leitura) {
        return ResponseEntity.ok(service.salvar(leitura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeituraSensor> atualizar(
            @PathVariable Long id,
            @RequestBody LeituraSensor leitura) {

        return ResponseEntity.ok(service.atualizar(id, leitura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}