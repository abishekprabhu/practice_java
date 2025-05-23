package com.hcltech.EmployeeManagement.dao.BatchDAO;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.model.Batch;

import java.util.List;
import java.util.Optional;

public interface BatchDaoService {

    void save(Batch batch);
    Optional<Batch> findById(Long id);
    List<Batch> findAll();
    void deleteById(Long id);
}
