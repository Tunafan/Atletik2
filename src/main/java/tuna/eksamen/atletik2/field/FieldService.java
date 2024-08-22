package tuna.eksamen.atletik2.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuna.eksamen.atletik2.event.EventDTO;

import java.util.List;
import java.util.stream.Collectors;

import static tuna.eksamen.atletik2.field.FieldRepository.*;

@Service
public class FieldService {

    @Autowired
    FieldRepository fieldRepository;

    public List<FieldDTO> getAllFields() {
        return fieldRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FieldDTO getFieldById(Long id) {
        Field field = fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found"));
        return convertToDTO(field);
    }

    private FieldDTO convertToDTO(Field field) {
        return new FieldDTO(field.getId(), field.getFieldType());
    }
}
