package tuna.eksamen.atletik2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuna.eksamen.atletik2.discipline.Discipline;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        return eventRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event(eventDTO.getDiscipline(), eventDTO.isGender(), eventDTO.getAgeGroup(), eventDTO.date(), eventDTO.getStartTime(), eventDTO.getField(), eventDTO.getDescription());
        event = eventRepository.save(event);
        return convertToDTO(event);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    existingEvent.setDisciplineID(eventDTO.getDiscipline());
                    existingEvent.setDate(eventDTO.getDate());
                    existingEvent.setGender(eventDTO.isGender());
                    existingEvent.setAgeGroup(eventDTO.getAgeGroup());
                    existingEvent.setStartTime(eventDTO.getStartTime());
                    existingEvent.setField(eventDTO.getField());
                    existingEvent.setDescription(eventDTO.getDescription());
                    return convertToDTO(eventRepository.save(existingEvent));
                }).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    private EventDTO convertToDTO(Event event) {
        return new EventDTO(event.getId(), event.getDisciplineID(), event.isGender(), event.getAgeGroup(), event.getDate(), event.getStartTime(), event.getField(), event.getDescription());
}

// mangler at arbejde videre på Discipline-package
  //  public Event getEventByDiscipline(Discipline discipline) {
    //    List<Event> events = eventRepository.findByDisciplineID(discipline);
      //  if (events.isEmpty()) {
      //      return null;
      //  }
      //  return events.get(0);
   // }
}
