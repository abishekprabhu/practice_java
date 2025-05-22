package com.hcltech.EmployeeManagement.service.Batch;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface BatchService {
    Batch save(Batch batch);
    Optional<Batch> findById(Long id);
    List<Batch> findAll();
}
