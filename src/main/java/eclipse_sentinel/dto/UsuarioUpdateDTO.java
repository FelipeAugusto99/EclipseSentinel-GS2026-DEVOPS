package eclipse_sentinel.dto;

import jakarta.validation.constraints.Email;

public record UsuarioUpdateDTO(

        String nome,

        @Email
        String email

) {
}