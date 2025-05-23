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

//    private final EmployeeService employeeService;
//
//    private final BatchRepository batchRepository;
//
//    private final EmployeeMapper employeeMapper;
//
//    @Override
//    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
///*        Batch batch = batchRepository.findById(dto.getBatchId())
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//
//        Employee emp = new Employee();
//        emp.setName(dto.getName());
//        emp.setEmail(dto.getEmail());
//        emp.setRole(dto.getRole());
//        emp.setBatch(batch);*/
//
//        Employee emp = employeeMapper.mapToEntity(dto);
////        emp.setMarks(dt);
//        return employeeMapper.mapToDTO(employeeService.save(emp));
//    }
//
//    @Override
//    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
//        Employee emp = employeeService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
///*        emp.setName(dto.getName());
//        emp.setEmail(dto.getEmail());
//        emp.setRole(dto.getRole());
//        emp.setBatch(batchRepository.findById(dto.getBatchId())
//                .orElseThrow(() -> new RuntimeException("Batch not found")));*/
//
//        emp = employeeMapper.mapToEntity(dto);
//        return employeeMapper.mapToDTO(employeeService.save(emp));
//    }
//
//    @Override
//    public EmployeeResponseDTO getByEmployeeId(Long id) {
//        Employee emp = employeeService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//        return employeeMapper.mapToDTO(emp);
//    }
//
//    @Override
//    public List<EmployeeResponseDTO> getAllEmployees() {
//        return employeeService.findAll().stream()
//                .map(employeeMapper::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<EmployeeResponseDTO> getByBatchId(Long batchId) {
//        Batch batch = batchRepository.findById(batchId)
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//        return employeeService.findByBatchId(batch.getId()).stream()
//                .map(employeeMapper::mapToDTO)
//                .collect(Collectors.toList());
///*        return employeeService.findAll().stream()
//                .filter(emp -> emp.getBatch().getId().equals(batchId))
//                .map(EmployeeMapper::mapToDTO)
//                .collect(Collectors.toList());*/
//    }
//
//    @Override
//    public void deleteEmployee(Long id) {
//        employeeService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//        employeeService.deleteById(id);
//    }




}
