package com.hcltech.EmployeeManagement.repository;

import com.hcltech.EmployeeManagement.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Marks, Long> {
}
