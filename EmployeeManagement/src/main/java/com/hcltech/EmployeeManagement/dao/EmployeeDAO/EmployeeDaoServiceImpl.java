package com.hcltech.EmployeeManagement.dao.EmployeeDAO;

import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import com.hcltech.EmployeeManagement.service.Employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDaoServiceImpl {

    private final EmployeeService employeeService;

    private final BatchRepository batchRepository;

    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {
        Batch batch = batchRepository.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());
        emp.setBatch(batch);
//        emp.setMarks(dt);
        return EmployeeMapper.mapToDTO(employeeService.save(emp));
    }


}
