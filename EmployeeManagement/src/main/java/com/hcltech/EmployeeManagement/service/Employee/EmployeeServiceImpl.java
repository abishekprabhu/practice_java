package com.hcltech.EmployeeManagement.service.Employee;

import com.hcltech.EmployeeManagement.dao.EmployeeDAO.EmployeeDaoService;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import com.hcltech.EmployeeManagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDaoService employeeDaoService;

    private final BatchRepository batchRepository;

    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {

        Employee emp = employeeMapper.mapToEntity(dto);
        return employeeMapper.mapToDTO(employeeDaoService.save(emp));
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee emp = employeeDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp = employeeMapper.mapToEntity(dto);
        return employeeMapper.mapToDTO(employeeDaoService.save(emp));
    }

    @Override
    public EmployeeResponseDTO getByEmployeeId(Long id) {
        Employee emp = employeeDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.mapToDTO(emp);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeDaoService.findAll().stream()
                .map(employeeMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponseDTO> getByBatchId(Long batchId) {
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        return employeeDaoService.findByBatchId(batch.getId()).stream()
                .map(employeeMapper::mapToDTO)
                .collect(Collectors.toList());
/*        return employeeService.findAll().stream()
                .filter(emp -> emp.getBatch().getId().equals(batchId))
                .map(EmployeeMapper::mapToDTO)
                .collect(Collectors.toList());*/
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeDaoService.deleteById(id);
    }


}
