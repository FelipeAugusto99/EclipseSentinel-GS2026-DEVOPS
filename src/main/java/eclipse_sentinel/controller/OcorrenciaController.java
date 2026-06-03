package eclipse_sentinel.controller;

import eclipse_sentinel.entity.Ocorrencia;
import eclipse_sentinel.service.OcorrenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final OcorrenciaService service;

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.ok(service.salvar(ocorrencia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> atualizar(
            @PathVariable Long id,
            @RequestBody Ocorrencia ocorrencia) {

        return ResponseEntity.ok(service.atualizar(id, ocorrencia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        service.excluir(id);

        return ResponseEntity.noContent().build();
    }
}