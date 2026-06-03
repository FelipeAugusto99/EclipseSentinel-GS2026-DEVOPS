package eclipse_sentinel.service;

import eclipse_sentinel.entity.inheritance.Usuario;
import eclipse_sentinel.exception.ResourceNotFoundException;
import eclipse_sentinel.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario existente = buscarPorId(id);

        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());

        return repository.save(existente);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}