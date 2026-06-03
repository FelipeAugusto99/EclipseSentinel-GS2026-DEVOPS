package eclipse_sentinel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OcorrenciaCreateDTO(

        @NotBlank(message = "Descrição é obrigatória")
        String descricao,

        String imagemUrl,

        @NotNull(message = "Usuário é obrigatório")
        Long usuarioId,

        @NotNull(message = "Área é obrigatória")
        Long areaId
) {
}