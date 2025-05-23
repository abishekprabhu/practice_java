package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDaoService {
//    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
//    List<EmployeeResponseDTO> getAllEmployees();
//    List<EmployeeResponseDTO> getByBatchId(Long batchId);
//    EmployeeResponseDTO getByEmployeeId(Long id);
//    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);
//    void deleteEmployee(Long id);

    Employee save(Employee emp);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);
    List<Employee> findByBatchId(Long batchId);
}
