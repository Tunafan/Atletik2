package tuna.eksamen.atletik2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tuna.eksamen.atletik2.ageGroup.AgeGroup;
import tuna.eksamen.atletik2.ageGroup.AgeGroupRepository;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.discipline.DisciplineRepository;
import tuna.eksamen.atletik2.event.Event;
import tuna.eksamen.atletik2.event.EventRepository;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.field.FieldRepository;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;
import tuna.eksamen.atletik2.timeSlot.TimeSlotRepository;

import java.util.List;
@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private AgeGroupRepository ageGroupRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Override
    public void run(String... args)  {
        System.out.println("System booting");
        createData();
        System.out.println("Data created");
    }

    public void createData() {

        List<TimeSlot> timeSlotList = List.of(
                new TimeSlot(1, 480, 540),
                new TimeSlot(1, 540, 600),
                new TimeSlot(1, 600, 660),
                new TimeSlot(1, 660, 720),
                new TimeSlot(1, 720, 780),
                new TimeSlot(1, 780, 840),
                new TimeSlot(1, 840, 900),
                new TimeSlot(1, 900, 960),
                new TimeSlot(1, 960, 1020),
                new TimeSlot(1, 1020, 1080),
                new TimeSlot(2, 480, 540),
                new TimeSlot(2, 540, 600),
                new TimeSlot(2, 600, 660),
                new TimeSlot(2, 660, 720),
                new TimeSlot(2, 720, 780),
                new TimeSlot(2, 780, 840),
                new TimeSlot(2, 840, 900),
                new TimeSlot(2, 900, 960),
                new TimeSlot(2, 960, 1020),
                new TimeSlot(2, 1020, 1080),
                new TimeSlot(3, 480, 540),
                new TimeSlot(3, 540, 600),
                new TimeSlot(3, 600, 660),
                new TimeSlot(3, 660, 720),
                new TimeSlot(3, 720, 780),
                new TimeSlot(3, 780, 840),
                new TimeSlot(3, 840, 900),
                new TimeSlot(3, 900, 960),
                new TimeSlot(3, 960, 1020),
                new TimeSlot(3, 1020, 1080),
                new TimeSlot(4, 480, 540),
                new TimeSlot(4, 540, 600),
                new TimeSlot(4, 600, 660),
                new TimeSlot(4, 660, 720),
                new TimeSlot(4, 720, 780),
                new TimeSlot(4, 780, 840),
                new TimeSlot(4, 840, 900),
                new TimeSlot(4, 900, 960),
                new TimeSlot(4, 960, 1020),
                new TimeSlot(4, 1020, 1080),
                new TimeSlot(5, 480, 540),
                new TimeSlot(5, 540, 600),
                new TimeSlot(5, 600, 660),
                new TimeSlot(5, 660, 720),
                new TimeSlot(5, 720, 780),
                new TimeSlot(5, 780, 840),
                new TimeSlot(5, 840, 900),
                new TimeSlot(5, 900, 960),
                new TimeSlot(5, 960, 1020),
                new TimeSlot(5, 1020, 1080)
        );
        timeSlotRepository.saveAll(timeSlotList);

        List<Field> fieldList = List.of(
                new Field("Løb"),
                new Field("Længdespring"),
                new Field("Højdespring"),
                new Field("Kast"),
                new Field("Svømmepøl 1"),
                new Field("Svømmepøl 2"),
                new Field("Svømmepøl 3"),
                new Field("Breakdancecirkel")
        );
        fieldRepository.saveAll(fieldList);

        List<Discipline> disciplineList = List.of(
                new Discipline("100m løb", 30),
                new Discipline("200m løb", 30),
                new Discipline("400m løb", 30),
                new Discipline("800m løb", 30),
                new Discipline("1500m løb", 30),
                new Discipline("5000m løb", 30),
                new Discipline("10000m løb", 60),
                new Discipline("100m hæk", 30),
                new Discipline("200m hæk", 30),
                new Discipline("400m hæk", 30),
                new Discipline("3000m forhindringsløb", 45),
                new Discipline("Længdespring", 60),
                new Discipline("Højdespring", 60),
                new Discipline("Stangspring", 60),
                new Discipline("Kuglestød", 60),
                new Discipline("Diskoskast", 60),
                new Discipline("Spydkast", 60),
                new Discipline("Hammerkast", 60),
                new Discipline("100m butterfly", 30),
                new Discipline("200m svømning", 30),
                new Discipline("400m svømning", 30),
                new Discipline("800m svømning", 30),
                new Discipline("1500m svømning", 30),
                new Discipline("2000m svømning", 30),
                new Discipline("5m udspring", 60),
                new Discipline("Breakdance", 30)
        );
        disciplineRepository.saveAll(disciplineList);

        List<AgeGroup> ageGroupList = List.of(
                new AgeGroup("Børn", "Børn i alderen 0-8 år"),
                new AgeGroup("Junior", "Unge i alderen 9-14 år"),
                new AgeGroup("U20", "Unge i alderen 15-19 år"),
                new AgeGroup("Senior", "Voksne i alderen 20-40 år"),
                new AgeGroup("40+", "Voksne i alderen 41-49 år"),
                new AgeGroup("50+", "Voksne i alderen 50-59 år"),
                new AgeGroup("60+", "Voksne i alderen 60+ år")
        );
        ageGroupRepository.saveAll(ageGroupList);

            List<Event> eventList = List.of(
                new Event(1, true, 3, 11, 1, "100m løb for U20 kvinder"),
                new Event(1, false, 3, 12, 1, "100m løb for U20 mænd"),
                new Event(2, true, 3, 13, 1, "200m løb for U20 kvinder"),
                new Event(2, false, 3, 14, 1, "200m løb for U20 mænd"),
                new Event(3, true, 3, 15, 1, "400m løb for U20 kvinder"),
                new Event(3, false, 3, 16, 1, "400m løb for U20 mænd"),
                new Event(11, true, 1, 17, 1, "3000m forhindringsløb for børn (kvinder)"),
                new Event(11, false, 1, 18, 1, "3000m forhindringsløb for børn (mænd)"),
                new Event(11, true, 2, 19, 1, "3000m forhindringsløb for junior (kvinder)"),
                new Event(11, false, 2, 20, 1, "3000m forhindringsløb for junior (mænd)"),
                new Event(11, true, 3, 21, 1, "3000m forhindringsløb for U20 (kvinder)"),
                new Event(11, false, 3, 22, 1, "3000m forhindringsløb for U20 (mænd)"),
                new Event(11, true, 4, 23, 1, "3000m forhindringsløb for senior (kvinder)"),
                new Event(11, false, 4, 24, 1, "3000m forhindringsløb for senior (mænd)"),
                new Event(11, true, 5, 25, 1, "3000m forhindringsløb for 40+ (kvinder)"),
                new Event(11, false, 5, 26, 1, "3000m forhindringsløb for 40+ (mænd)"),
                new Event(11, true, 6, 27, 1, "3000m forhindringsløb for 50+ (kvinder)"),
                new Event(11, false, 6, 28, 1, "3000m forhindringsløb for 50+ (mænd)"),
                new Event(11, true, 7, 29, 1, "3000m forhindringsløb for 60+ (kvinder)"),
                new Event(11, false, 7, 30, 1, "3000m forhindringsløb for 60+ (mænd)")

        );
        eventRepository.saveAll(eventList);

    }
}