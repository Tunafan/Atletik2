package tuna.eksamen.atletik2.ageGroup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public AgeGroup() {
    }
    public AgeGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public AgeGroup(String name){
        this.name = name;
    }

    public AgeGroup(int ageGroup) {
        this.id = (long) ageGroup;
    }
}
