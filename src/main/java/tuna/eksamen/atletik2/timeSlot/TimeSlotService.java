package tuna.eksamen.atletik2.timeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    public List<TimeSlot> getTimeSlotsByDay (int day) {
        return timeSlotRepository.findByDay(day);
    }
    public Optional<TimeSlot> getTimeSlotById(Long id) {
        return timeSlotRepository.findById(id);
    }


    public boolean isTimeSlotAvailable(int day, int startTime, int endTime) {
        List<TimeSlot> existingTimeSlots = timeSlotRepository.findAll();
        for (TimeSlot slot : existingTimeSlots) {
            if (slot.getDay() == day && (
                    (startTime >= slot.getStartTime() && startTime < slot.getEndTime()) ||
                            (endTime > slot.getStartTime() && endTime <= slot.getEndTime()) ||
                            (startTime <= slot.getStartTime() && endTime >= slot.getEndTime())
            )) {
                return false; // Time slot is not available
            }
        }
        return true; // Time slot is available
    }
}
