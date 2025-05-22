package com.hcltech.EmployeeManagement.dto.Employee;

import com.hcltech.EmployeeManagement.model.Enum.Role;
import lombok.Data;

@Data
public class EmployeeRequestDTO {
    private String name;
    private String email;
    private Role role;
    private Long batchId;
}
