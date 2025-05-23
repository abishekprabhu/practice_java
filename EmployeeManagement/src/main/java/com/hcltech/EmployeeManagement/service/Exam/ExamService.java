package com.hcltech.EmployeeManagement.service.Exam;


import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.model.Exam;

import java.util.*;

public interface ExamService {

    ExamResponseDTO createExam(ExamRequestDTO dto);
    ExamResponseDTO getExamById(Long id);
    List<ExamResponseDTO> getAllExams();
    ExamResponseDTO updateExam(Long id, ExamRequestDTO dto);
    void deleteExam(Long id);

}
