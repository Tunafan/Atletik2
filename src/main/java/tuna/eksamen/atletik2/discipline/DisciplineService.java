package tuna.eksamen.atletik2.discipline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }
    public Optional<Discipline> getDisciplineById(Long id) {
        return disciplineRepository.findById(id);
    }
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }
    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }
}
