package com.hcltech.EmployeeManagement.dao.ExamDAO;

import com.hcltech.EmployeeManagement.model.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamDaoService {
    Exam save(Exam exam);
    Optional<Exam> findById(Long id);
    List<Exam> findAll();
    void deleteById(Long id);
    List<Exam> findByBatchId(Long batchId);
}
