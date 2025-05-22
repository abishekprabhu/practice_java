package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;

public interface EmployeeDaoService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
}
