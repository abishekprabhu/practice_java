package com.hcltech.EmployeeManagement.repository;

import com.hcltech.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
