package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDaoService {
    Employee save(Employee emp);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
    List<Employee> findByBatchId(Long batchId);
}
