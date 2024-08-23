package tuna.eksamen.atletik2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuna.eksamen.atletik2.field.Field;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;

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
        Event event = new Event(eventDTO.getDiscipline(), eventDTO.isGender(), eventDTO.getAgeGroup(), eventDTO.getTimeSlot() , eventDTO.getField(), eventDTO.getDescription());
        event = eventRepository.save(event);
        return convertToDTO(event);
    }
    public Event saveEvent(Event event) {
        if (isFieldAvailable(event.getField(), event.getTimeSlot())) {
            return eventRepository.save(event);
        } else {
            throw new IllegalArgumentException("Banen er optaget på dette tidspunkt :(");
        }
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    existingEvent.setDisciplineID(eventDTO.getDiscipline());
                    existingEvent.setGender(eventDTO.isGender());
                    existingEvent.setAgeGroup(eventDTO.getAgeGroup());
                    existingEvent.setTimeSlot(eventDTO.getTimeSlot());
                    existingEvent.setField(eventDTO.getField());
                    existingEvent.setDescription(eventDTO.getDescription());
                    return convertToDTO(eventRepository.save(existingEvent));
                }).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);

    }

    private boolean isFieldAvailable(Field field, TimeSlot timeSlot) {
        List<Event> eventsAtSameTime = eventRepository.findByTimeSlot(timeSlot);
        System.out.println("Checking availability for field: " + field.getFieldType() + " at time slot: " + timeSlot.getId());

        for (Event existingEvent : eventsAtSameTime) {
            System.out.println("Existing event at time slot: " + existingEvent.getDescription() + " on field: " + existingEvent.getField().getFieldType());
            if (existingEvent.getField().equals(field)) {
                System.out.println("Field is already booked for this time slot.");
                return false; // Bane optaget
            }
        }
        System.out.println("Field is available.");
        return true; // Bane ledig
    }

    private EventDTO convertToDTO(Event event) {
        return new EventDTO(event.getId(), event.getDisciplineID(), event.isGender(), event.getAgeGroup(), event.getTimeSlot(), event.getField(), event.getDescription());
}

}
