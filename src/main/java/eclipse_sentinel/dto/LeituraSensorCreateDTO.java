package eclipse_sentinel.dto;

import jakarta.validation.constraints.NotNull;

public record LeituraSensorCreateDTO(

        @NotNull
        Double temperatura,

        @NotNull
        Double umidade,

        @NotNull
        Double fumaca,

        @NotNull
        Long sensorId

) {
}