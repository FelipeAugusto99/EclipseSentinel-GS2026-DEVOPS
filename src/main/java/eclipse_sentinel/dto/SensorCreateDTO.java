package eclipse_sentinel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SensorCreateDTO(

        @NotBlank
        String tipoSensor,

        @NotBlank
        String statusSensor,

        @NotNull
        Long areaId

) {
}