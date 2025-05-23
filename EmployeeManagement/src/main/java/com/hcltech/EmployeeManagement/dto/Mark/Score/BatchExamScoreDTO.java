package com.hcltech.EmployeeManagement.dto.Mark.Score;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BatchExamScoreDTO {
    private String batchCode;
    private List<ExamScoreDTO> exams;
}

/*
*
* [
 {
   "batchCode": "JAVA-FSD-5116",
   "exams": [
     {
       "examName": "Java Basics",
       "examDate": "2025-05-20",
       "scores": [
         {
           "employeeName": "Abishek Prabhu",
           "score": 95
         },
         {
           "employeeName": "Ravi Kumar",
           "score": 90
         }
       ]
     },
     {
       "examName": "Spring Boot",
       "examDate": "2025-05-22",
       "scores": [
         {
           "employeeName": "Ravi Kumar",
           "score": 97
         },
         {
           "employeeName": "Abishek Prabhu",
           "score": 88
         }
       ]
     }
   ]
 }
]*/