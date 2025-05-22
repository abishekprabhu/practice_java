package com.hcltech.EmployeeManagement.service.Employee;

import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee emp);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
    List<Employee> findByBatchId(Long batchId);
}
