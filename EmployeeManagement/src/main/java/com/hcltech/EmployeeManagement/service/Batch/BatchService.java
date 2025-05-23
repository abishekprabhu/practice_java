package com.hcltech.EmployeeManagement.service.Batch;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface BatchService {
    BatchDTO createBatch(BatchDTO dto);
    BatchDTO getBatchById(Long id);
    List<BatchDTO> getAllBatches();
    BatchDTO updateBatch(Long id, BatchDTO dto);
    void deleteBatch(Long id);

    List<BatchExamScoreDTO> getMarksByBatchExamWiseSorted();
}
