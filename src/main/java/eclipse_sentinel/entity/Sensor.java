package eclipse_sentinel.entity;

import eclipse_sentinel.entity.enums.TipoSensor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GS_ECLIPSE_SENSOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SENSOR")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_SENSOR")
    private TipoSensor tipoSensor;

    @Column(name = "STATUS_SENSOR")
    private String statusSensor;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private Area area;
}