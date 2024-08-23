package tuna.eksamen.atletik2.field;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    public Field(int field) {
        this.id = (long) field;
    }


    // override af equals og hashCode for at kunne sammenligne objekter
    //implementeret for at kunne sammenligne objekter i testklasser (om repræsenterer samme objekt i db)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(id, field.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}