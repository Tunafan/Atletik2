package tuna.eksamen.atletik2.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tuna.eksamen.atletik2.ageGroup.AgeGroup;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;
    private Discipline discipline;
    private boolean gender;
    private AgeGroup ageGroup;
    private TimeSlot timeSlot;
    private Field field;
    private String description;


    public EventDTO(Discipline discipline, boolean gender, AgeGroup ageGroup, TimeSlot timeSlot, Field field, String description) {
        this.discipline = discipline;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.timeSlot = timeSlot;
        this.field = field;
        this.description = description;
    }

}
