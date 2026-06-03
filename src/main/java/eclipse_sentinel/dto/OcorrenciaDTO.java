package eclipse_sentinel.dto;

import java.time.LocalDateTime;

public record OcorrenciaDTO(
        Long id,
        String descricao,
        String imagemUrl,
        LocalDateTime dataOcorrencia,
        Long usuarioId,
        Long areaId
) {
}