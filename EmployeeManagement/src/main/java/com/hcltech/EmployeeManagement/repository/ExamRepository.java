package com.hcltech.EmployeeManagement.repository;

import com.hcltech.EmployeeManagement.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByBatchId(Long batchId);
}
