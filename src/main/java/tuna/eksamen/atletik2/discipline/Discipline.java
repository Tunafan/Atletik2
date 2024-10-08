package tuna.eksamen.atletik2.discipline;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration; //minutter

    public Discipline() {
    }
    public Discipline(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Discipline(int disciplineID) {
        this.id = (long) disciplineID;
    }
}
