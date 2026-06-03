package eclipse_sentinel.entity.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Pessoa {

    @Column(name = "NOME", nullable = false)
    protected String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    protected String email;
}