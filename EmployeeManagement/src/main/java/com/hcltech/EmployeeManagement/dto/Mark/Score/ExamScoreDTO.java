package com.hcltech.EmployeeManagement.dto.Mark.Score;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ExamScoreDTO {

    private String examName;
    private LocalDate examDate;
    private List<ScoreDTO> scores;

}
