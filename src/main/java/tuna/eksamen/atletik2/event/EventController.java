package tuna.eksamen.atletik2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tuna.eksamen.atletik2.discipline.Discipline;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService; // meget bedre end @Autowired

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping ("/")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping ("/")
    public ResponseEntity<EventDTO> createEvent(EventDTO eventDTO) {
        EventDTO savedEvent = eventService.createEvent(eventDTO);
        return ResponseEntity.ok(savedEvent);
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.updateEvent(id, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

  //  @GetMapping ("/discipline/{discipline}")
  //  public Event getEventByDiscipline(Discipline discipline) {
  //      return eventService.getEventByDiscipline(discipline);
  //  }


}
