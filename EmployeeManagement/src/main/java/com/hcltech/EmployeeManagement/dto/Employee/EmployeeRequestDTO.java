package com.hcltech.EmployeeManagement.dto.Employee;

import com.hcltech.EmployeeManagement.model.Enum.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

//    @NotNull(message="Salary is required")
//    @Min(value = 10000, message = "salary must be at least 10000");
//    private Double salary;

//    @Size(min = 10 , max = 10, message ="Phone is must be 10 digits ")
//    private String phone;

    private Role role;

    @NotNull(message = "batch_id is required")
    private Long batchId;
}
