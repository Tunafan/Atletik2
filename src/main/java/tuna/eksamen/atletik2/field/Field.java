package tuna.eksamen.atletik2.field;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fieldType;

    public Field( String fieldType) {
        this.fieldType = fieldType;
    }

    public Field() {

    }
}