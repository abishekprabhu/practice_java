package com.hcltech.EmployeeManagement.dao.ExamDAO;

import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.model.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamDaoService {
/*
    ExamResponseDTO createExam(ExamRequestDTO dto);
    ExamResponseDTO getExamById(Long id);
    List<ExamResponseDTO> getAllExams();
    ExamResponseDTO updateExam(Long id, ExamRequestDTO dto);
    void deleteExam(Long id);
*/


    Exam save(Exam exam);
    Optional<Exam> findById(Long id);
    List<Exam> findAll();
    void deleteById(Long id);
    List<Exam> findByBatchId(Long batchId);
}
