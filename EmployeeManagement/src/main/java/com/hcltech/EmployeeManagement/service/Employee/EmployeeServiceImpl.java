package com.hcltech.EmployeeManagement.service.Employee;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

//    @Override
//    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
//        Employee employee = new Employee();
//        employee.setName(dto.getName());
//        employee.setEmail(dto.getEmail());
//        employee.setRole(dto.getRole());
//
//        return EmployeeMapper.mapToDTO(employee);
//    }


    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }
}
