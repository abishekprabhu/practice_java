package com.hcltech.EmployeeManagement.dto.Exam;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamResponseDTO {
    private Long id;
    private String name;
    private LocalDate date;
    private String batchCode;
}
