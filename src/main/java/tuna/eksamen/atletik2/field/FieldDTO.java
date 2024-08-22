package tuna.eksamen.atletik2.field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {
    private Long id;
    private String fieldType;

    public FieldDTO(String fieldType) {
        this.fieldType = fieldType;
    }

}
