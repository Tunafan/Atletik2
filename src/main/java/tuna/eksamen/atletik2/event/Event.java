package tuna.eksamen.atletik2.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tuna.eksamen.atletik2.ageGroup.AgeGroup;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.field.Field;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Discipline disciplineID;
    private boolean gender; //true=woman. false=man.
    @ManyToOne
    private AgeGroup ageGroup;
    private int date;
    private double startTime;
    @ManyToOne
    private Field field;
    private String description;

public Event () {

}
    public Event(Discipline disciplineID, boolean gender, AgeGroup ageGroup, int date, double startTime, Field field, String description) {
        this.disciplineID = disciplineID;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.date = date;
        this.startTime = startTime;
        this.field = field;
        this.description = description;
}


}
