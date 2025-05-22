package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeDaoService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
    List<EmployeeResponseDTO> getAllEmployees();
    List<EmployeeResponseDTO> getByBatchId(Long batchId);
    EmployeeResponseDTO getEmployeeById(Long id);
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);
    void deleteEmployee(Long id);
}
