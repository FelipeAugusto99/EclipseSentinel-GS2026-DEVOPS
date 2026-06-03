package eclipse_sentinel.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    private Double latitude;

    private Double longitude;
}