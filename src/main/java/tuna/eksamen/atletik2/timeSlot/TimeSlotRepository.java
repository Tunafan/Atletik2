package tuna.eksamen.atletik2.timeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    //method to find timeslot by day number:
    List<TimeSlot> findByDay(int day);

}
