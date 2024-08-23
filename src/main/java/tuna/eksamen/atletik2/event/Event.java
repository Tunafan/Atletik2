package tuna.eksamen.atletik2.event;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuna.eksamen.atletik2.ageGroup.AgeGroup;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Discipline disciplineID;
    private boolean gender; //true=woman. false=man.
    @ManyToOne
    private AgeGroup ageGroup;
    @ManyToOne
    private TimeSlot timeSlot;
    @ManyToOne
    private Field field;
    private String description;

    public Event (int disciplineID, boolean gender, int ageGroup, int timeSlot, int field, String description) {
        this.disciplineID = new Discipline(disciplineID);
        this.gender = gender;
        this.ageGroup = new AgeGroup(ageGroup);
        this.timeSlot = new TimeSlot(timeSlot);
        this.field = new Field(field);
        this.description = description;

    }
    public Event(Discipline disciplineID, boolean gender, AgeGroup ageGroup, TimeSlot timeSlot, Field field, String description) {
        this.disciplineID = disciplineID;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.timeSlot = timeSlot;
        this.field = field;
        this.description = description;
}

}
