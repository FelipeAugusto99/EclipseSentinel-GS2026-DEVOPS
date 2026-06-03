package eclipse_sentinel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlertaCreateDTO(

        @NotBlank(message = "Tipo do alerta é obrigatório")
        String tipoAlerta,

        @NotBlank(message = "Severidade é obrigatória")
        String severidade,

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        @NotNull(message = "Área é obrigatória")
        Long areaId
) {
}