package com.hcltech.EmployeeManagement.service.Employee;

import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

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
