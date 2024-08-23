package tuna.eksamen.atletik2.ageGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ages")
public class AgeGroupController {

    @Autowired
    private AgeGroupService ageGroupService;

    @GetMapping
    public ResponseEntity<List<AgeGroupDTO>> getAllAgeGroups() {
        List<AgeGroupDTO> ageGroups = ageGroupService.getAllAgeGroups()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(ageGroups);
    }


    @GetMapping("/{id}")
    public AgeGroupDTO getAgeGroupById(@PathVariable Long id) {
        return ageGroupService.getAgeGroupById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    private AgeGroupDTO convertToDTO(AgeGroup ageGroup) {
        return new AgeGroupDTO(ageGroup.getId(), ageGroup.getName(), ageGroup.getDescription());
    }
}
