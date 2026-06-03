package eclipse_sentinel.hateoas;

import eclipse_sentinel.controller.OcorrenciaController;
import eclipse_sentinel.dto.OcorrenciaDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class OcorrenciaModelAssembler
        implements RepresentationModelAssembler<OcorrenciaDTO, EntityModel<OcorrenciaDTO>> {

    @Override
    public EntityModel<OcorrenciaDTO> toModel(OcorrenciaDTO ocorrencia) {

        return EntityModel.of(ocorrencia,

                linkTo(methodOn(OcorrenciaController.class)
                        .buscar(ocorrencia.id()))
                        .withSelfRel(),

                linkTo(methodOn(OcorrenciaController.class)
                        .listar())
                        .withRel("ocorrencias")
        );
    }
}