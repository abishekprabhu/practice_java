package com.hcltech.EmployeeManagement.service.Batch;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    @Override
     public BatchDTO createBatch(BatchDTO dto) {

         BatchDTO batchDTO = new BatchDTO();
         batchDTO.setBatchCode(dto.getBatchCode());

         return batchDTO;
     }




}
