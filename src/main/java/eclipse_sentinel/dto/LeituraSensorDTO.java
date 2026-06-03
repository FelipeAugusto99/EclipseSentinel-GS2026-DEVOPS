package eclipse_sentinel.dto;

import java.time.LocalDateTime;

public record LeituraSensorDTO(
        Long id,
        Double temperatura,
        Double umidade,
        Double fumaca,
        LocalDateTime dataLeitura,
        Long sensorId
) {
}