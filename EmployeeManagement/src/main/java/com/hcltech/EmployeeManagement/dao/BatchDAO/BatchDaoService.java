package com.hcltech.EmployeeManagement.dao.BatchDAO;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;

import java.util.List;

public interface BatchDaoService {

    BatchDTO createBatch(BatchDTO dto);
    BatchDTO getBatchById(Long id);
    List<BatchDTO> getAllBatches();
    BatchDTO updateBatch(Long id, BatchDTO dto);
    void deleteBatch(Long id);
}
