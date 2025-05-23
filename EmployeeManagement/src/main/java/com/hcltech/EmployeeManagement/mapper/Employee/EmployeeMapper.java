package com.hcltech.EmployeeManagement.mapper.Employee;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final BatchRepository batchRepository;

    public EmployeeResponseDTO mapToDTO(Employee emp){
//        return new EmployeeResponseDTO(emp.getId(),emp.getName(), emp.getEmail(), emp.getRole());

        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setRole(emp.getRole());
        dto.setBatchCode(emp.getBatch().getBatchCode());

        List<MarksDTO> marksList = Optional.ofNullable(emp.getMarks())
                .orElse(Collections.emptyList())
                .stream()
                .map(mark -> {
                    MarksDTO marksDTO = new MarksDTO();
                    marksDTO.setExamName(mark.getExam().getName());
                    marksDTO.setScore(mark.getScore());
                    return marksDTO;
                })
                .toList();

//        List<MarksDTO> marksList = emp.getMarks().stream().map(mark -> {
//            MarksDTO marksDTO = new MarksDTO();
//            marksDTO.setExamName(mark.getExam().getName());
//            marksDTO.setScore(mark.getScore());
//            return marksDTO;
//        }).toList();

        dto.setMarks(marksList);

        return dto;
    }

    //mapToEntity method
    public Employee mapToEntity(EmployeeRequestDTO dto){
        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        Employee emp = new Employee();
//        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());
        emp.setBatch(batch);
        return emp;
    }
}
