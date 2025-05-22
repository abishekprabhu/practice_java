package com.hcltech.EmployeeManagement.dto.Employee;

import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.model.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private String batchCode;
    private List<MarksDTO> marks;

}
