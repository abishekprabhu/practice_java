package com.hcltech.EmployeeManagement.controller;

import com.hcltech.EmployeeManagement.dao.EmployeeDAO.EmployeeDaoService;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.service.Employee.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingFormatArgumentException;

@RestController
@RequestMapping("/api/employeeService/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create( @RequestBody @Valid EmployeeRequestDTO dto){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(dto));
        }catch (MissingFormatArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getByEmployeeId(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAll(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@PathVariable Long id,@Valid @RequestBody EmployeeRequestDTO dto){
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(id,dto));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
