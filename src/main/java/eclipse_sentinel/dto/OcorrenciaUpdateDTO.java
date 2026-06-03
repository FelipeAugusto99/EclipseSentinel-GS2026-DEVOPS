package eclipse_sentinel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OcorrenciaUpdateDTO(

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        String imagemUrl,

        @NotNull(message = "Área é obrigatória")
        Long areaId
) {
}