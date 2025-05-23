package com.hcltech.EmployeeManagement.mapper.Mark;

import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.model.Marks;

public class MarkMapper {

    public static MarksDTO mapToDTO(Marks mark) {
        MarksDTO dto = new MarksDTO();
        dto.setExamName(mark.getExam().getName());
        dto.setScore(mark.getScore());
        return dto;
    }
}
