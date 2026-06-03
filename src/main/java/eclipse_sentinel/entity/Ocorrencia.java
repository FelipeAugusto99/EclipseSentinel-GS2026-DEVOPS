package eclipse_sentinel.entity;

import eclipse_sentinel.entity.inheritance.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "GS_ECLIPSE_OCORRENCIA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OCORRENCIA")
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_OCORRENCIA")
    private LocalDateTime dataOcorrencia;

    @Column(name = "IMAGEM_URL")
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_AREA")
    private Area area;
}