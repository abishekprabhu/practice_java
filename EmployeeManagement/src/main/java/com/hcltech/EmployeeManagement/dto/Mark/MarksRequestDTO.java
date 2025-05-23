package com.hcltech.EmployeeManagement.dto.Mark;

import lombok.Data;

@Data
public class MarksRequestDTO {

    private Long employeeId;
    private Long examId;
    private Integer score;
}

