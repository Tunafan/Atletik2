package tuna.eksamen.atletik2.discipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    public List<DisciplineDTO> getAllDisciplines() {
        return disciplineService.getAllDisciplines()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public DisciplineDTO getDisciplineById(@PathVariable Long id) {
        return disciplineService.getDisciplineById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    private DisciplineDTO convertToDTO(Discipline discipline) {
        return new DisciplineDTO(discipline.getId(), discipline.getName(), discipline.getDuration());
    }


}
