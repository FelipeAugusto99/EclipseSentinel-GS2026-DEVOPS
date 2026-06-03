package eclipse_sentinel.entity;

import eclipse_sentinel.entity.enums.Severidade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "GS_ECLIPSE_ALERTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERTA")
    private Long id;

    @Column(name = "TIPO_ALERTA")
    private String tipoAlerta;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEVERIDADE")
    private Severidade severidade;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_ALERTA")
    private LocalDateTime dataAlerta;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private Area area;

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }
}