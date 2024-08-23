package tuna.eksamen.atletik2.ageGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgeGroupService {

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    public List<AgeGroup> getAllAgeGroups() {
        return ageGroupRepository.findAll();
    }

    public Optional<AgeGroup> getAgeGroupById(Long id) {
        return ageGroupRepository.findById(id);
    }

    public AgeGroup saveAgeGroup(AgeGroup ageGroup) {
        return ageGroupRepository.save(ageGroup);
    }

    public void deleteAgeGroup(Long id) {
        ageGroupRepository.deleteById(id);
    }
}
