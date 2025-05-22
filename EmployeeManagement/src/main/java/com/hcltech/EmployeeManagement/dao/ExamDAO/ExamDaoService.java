package com.hcltech.EmployeeManagement.dao.ExamDAO;

import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;

import java.util.List;

public interface ExamDaoService {
    ExamResponseDTO createExam(ExamRequestDTO dto);
    ExamResponseDTO getExamById(Long id);
    List<ExamResponseDTO> getAllExams();
    ExamResponseDTO updateExam(Long id, ExamRequestDTO dto);
    void deleteExam(Long id);
}
