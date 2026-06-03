package eclipse_sentinel.dto;

import java.time.LocalDateTime;

public record AlertaDTO(
        Long id,
        String tipoAlerta,
        String severidade,
        String descricao,
        LocalDateTime dataAlerta,
        Long areaId
) {
}