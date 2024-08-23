package tuna.eksamen.atletik2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tuna.eksamen.atletik2.ageGroup.AgeGroup;
import tuna.eksamen.atletik2.ageGroup.AgeGroupRepository;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.discipline.DisciplineRepository;
import tuna.eksamen.atletik2.event.Event;
import tuna.eksamen.atletik2.event.EventService;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.field.FieldRepository;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;
import tuna.eksamen.atletik2.timeSlot.TimeSlotRepository;

import java.util.Optional;

@Component
public class CrashTest implements CommandLineRunner {
//Test afprøver, om det er muligt at booke en bane på et tidspunkt, hvor den allerede er i brug
    @Autowired
    private EventService eventService;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Override
    public void run(String... args) {
        System.out.println("Starter crashtest");

        // book Field til løb (id = 1) til samme Timeslot som et andet eksisterende event
        Optional<Field> field = fieldRepository.findById(1L);
        Optional<TimeSlot> timeSlot = timeSlotRepository.findById(25L); // timeslot allerede i brug fra InitData
        Optional<Discipline> discipline = disciplineRepository.findById(1L); // 100m sprint = ID 1
        Optional<AgeGroup> ageGroup = ageGroupRepository.findById(3L); // 40+ age group = ID 3

        if (field.isPresent() && timeSlot.isPresent() && discipline.isPresent() && ageGroup.isPresent()) {
            Event newEvent = new Event(
                    discipline.get(), true, ageGroup.get(), timeSlot.get(), field.get(), "Crash Test Event"
            );

            try {
                eventService.saveEvent(newEvent); //hvis lykkes, så er der noget galt
                System.out.println("Crash Test fejlet: Eventet skulle ikke have været booket på banen.");
            } catch (IllegalArgumentException error) {
                System.out.println("Crash Test bestået: " + error.getMessage());
            }
        } else {
            System.out.println("Noget helt galtæ Der er slet ikke noget data at teste på.");
        }
    }
}

