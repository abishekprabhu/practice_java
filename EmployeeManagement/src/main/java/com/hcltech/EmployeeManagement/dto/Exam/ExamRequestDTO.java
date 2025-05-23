package com.hcltech.EmployeeManagement.dto.Exam;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamRequestDTO {
    private String name;
    private LocalDate date;
    private Long batchId;
}
