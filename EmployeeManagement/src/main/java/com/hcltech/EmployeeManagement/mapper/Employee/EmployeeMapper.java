package com.hcltech.EmployeeManagement.mapper.Employee;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeResponseDTO mapToDTO(Employee emp){
//        return new EmployeeResponseDTO(emp.getId(),emp.getName(), emp.getEmail(), emp.getRole());

        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setRole(emp.getRole());
        dto.setBatchCode(emp.getBatch().getBatchCode());

        List<MarksDTO> marksList = emp.getMarks().stream().map(mark -> {
            MarksDTO marksDTO = new MarksDTO();
            marksDTO.setExamName(mark.getExam().getName());
            marksDTO.setScore(mark.getScore());
            return marksDTO;
        }).toList();

        dto.setMarks(marksList);

        return dto;
    }
}
