package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import com.hcltech.EmployeeManagement.repository.EmployeeRepository;
import com.hcltech.EmployeeManagement.service.Employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeDaoServiceImpl implements EmployeeDaoService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByBatchId(Long batchId) {
        return employeeRepository.findByBatchId(batchId);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }


}
