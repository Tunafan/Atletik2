package tuna.eksamen.atletik2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tuna.eksamen.atletik2.event.Event;
import tuna.eksamen.atletik2.event.EventRepository;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.field.FieldRepository;

import java.util.List;
@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public void run(String... args)  {
        System.out.println("System booting");
        createData();
        System.out.println("Data created");
    }

    public void createData() {

        //lav fields
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

        //lav events

    }
}