package eclipse_sentinel.repository;

import eclipse_sentinel.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}