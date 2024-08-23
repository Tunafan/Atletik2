package tuna.eksamen.atletik2.timeSlot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timeslots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlotDTO> getAllTimeSlots() {
        return timeSlotService.getAllTimeSlots()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public TimeSlotDTO getTimeSlotById(@PathVariable Long id) {
        return timeSlotService.getTimeSlotById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    @GetMapping("/{day}")
    public List<TimeSlotDTO> getTimeSlotsByDay(@PathVariable int day) {
        return timeSlotService.getTimeSlotsByDay(day)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private TimeSlotDTO convertToDTO(TimeSlot timeSlot) {
        return new TimeSlotDTO(timeSlot.getId(), timeSlot.getDay(), timeSlot.getStartTime(), timeSlot.getEndTime());
    }
    
}
