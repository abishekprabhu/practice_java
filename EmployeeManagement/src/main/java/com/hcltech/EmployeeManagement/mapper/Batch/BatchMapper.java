package com.hcltech.EmployeeManagement.mapper.Batch;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {

    public BatchDTO mapToDTO(Batch batch) {
        BatchDTO dto = new BatchDTO();
        dto.setId(batch.getId());
        dto.setBatchCode(batch.getBatchCode());
        return dto;
    }
}