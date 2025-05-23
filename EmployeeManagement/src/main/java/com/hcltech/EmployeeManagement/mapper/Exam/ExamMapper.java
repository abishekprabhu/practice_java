package com.hcltech.EmployeeManagement.mapper.Exam;

import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.model.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {

    public ExamResponseDTO mapToDTO(Exam exam) {
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setDate(exam.getDate());
        dto.setBatchCode(exam.getBatch().getBatchCode());
        return dto;
    }
}
