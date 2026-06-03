package eclipse_sentinel.entity;

import eclipse_sentinel.entity.embedded.Localizacao;
import eclipse_sentinel.entity.enums.NivelRisco;
import eclipse_sentinel.entity.enums.StatusArea;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GS_ECLIPSE_AREA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AREA")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Embedded
    private Localizacao localizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_AREA")
    private StatusArea status;

    @Enumerated(EnumType.STRING)
    @Column(name = "NIVEL_RISCO")
    private NivelRisco nivelRisco;
}