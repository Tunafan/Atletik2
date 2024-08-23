package tuna.eksamen.atletik2.ageGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgeGroupDTO {
    private Long id;
    private String name;
    private String description;

    public AgeGroupDTO(String name) {
        this.name = name;
    }
    public AgeGroupDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AgeGroupDTO(Long id, String name) {
    }
}
