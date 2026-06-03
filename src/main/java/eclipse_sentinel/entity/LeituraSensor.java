package eclipse_sentinel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "GS_ECLIPSE_LEITURA_SENSOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeituraSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LEITURA")
    private Long id;

    private Double temperatura;

    private Double umidade;

    private Double fumaca;

    @Column(name = "DATA_LEITURA")
    private LocalDateTime dataLeitura;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR")
    private Sensor sensor;
}