package com.hcltech.EmployeeManagement.repository;

import com.hcltech.EmployeeManagement.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepository extends JpaRepository<Batch, Long> {
}
