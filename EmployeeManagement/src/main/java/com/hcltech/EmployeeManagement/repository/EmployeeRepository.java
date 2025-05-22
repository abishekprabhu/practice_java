package com.hcltech.EmployeeManagement.repository;

import com.hcltech.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByBatchId(Long batchId);
}
