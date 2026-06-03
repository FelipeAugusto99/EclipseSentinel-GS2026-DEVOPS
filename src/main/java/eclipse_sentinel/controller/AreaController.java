package eclipse_sentinel.controller;

import eclipse_sentinel.entity.Area;
import eclipse_sentinel.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService service;

    @GetMapping
    public ResponseEntity<List<Area>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Area> criar(@RequestBody Area area) {
        return ResponseEntity.ok(service.salvar(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> atualizar(
            @PathVariable Long id,
            @RequestBody Area area) {

        return ResponseEntity.ok(service.atualizar(id, area));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}