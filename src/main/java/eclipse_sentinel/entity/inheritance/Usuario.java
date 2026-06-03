package eclipse_sentinel.entity.inheritance;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GS_ECLIPSE_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "ROLE")
    private String role;
}