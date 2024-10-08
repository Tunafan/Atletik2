package tuna.eksamen.atletik2.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tuna.eksamen.atletik2.discipline.Discipline;
import tuna.eksamen.atletik2.timeSlot.TimeSlot;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTimeSlot(TimeSlot timeSlot);
}
