package eclipse_sentinel.hateoas;

import eclipse_sentinel.controller.UsuarioController;
import eclipse_sentinel.dto.UsuarioDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UsuarioModelAssembler
        implements RepresentationModelAssembler<UsuarioDTO, EntityModel<UsuarioDTO>> {

    @Override
    public EntityModel<UsuarioDTO> toModel(UsuarioDTO usuario) {

        return EntityModel.of(usuario,

                linkTo(methodOn(UsuarioController.class)
                        .buscar(usuario.id()))
                        .withSelfRel(),

                linkTo(methodOn(UsuarioController.class)
                        .listar())
                        .withRel("usuarios")
        );
    }
}