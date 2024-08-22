package tuna.eksamen.atletik2.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("/all")
    public ResponseEntity<List<FieldDTO>> getAllFields() {
        List<FieldDTO> fields = fieldService.getAllFields();
        return ResponseEntity.ok(fields);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FieldDTO> getFieldById(@PathVariable Long id) {
        FieldDTO field = fieldService.getFieldById(id);
        return ResponseEntity.ok(field);
    }

}
