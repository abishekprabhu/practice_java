package com.hcltech.EmployeeManagement.dao.BatchDAO;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.mapper.BatchMapper;
import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.service.Batch.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatchDaoServiceImpl implements BatchDaoService {

    private  BatchService batchService;

    private final BatchMapper batchMapper;

    @Override
    public BatchDTO createBatch(BatchDTO dto) {
        Batch batch = new Batch();
        batch.setBatchCode(dto.getBatchCode());
        batchService.save(batch);
        return batchMapper.mapToDTO(batch);
    }

    @Override
    public BatchDTO getBatchById(Long id) {
        Batch batch = batchService.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        return batchMapper.mapToDTO(batch);
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        return batchService.findAll().stream()
                .map(EmployeeMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatchDTO updateBatch(Long id, BatchDTO dto) {
        Batch batch = batchService.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        batch.setBatchCode(dto.getBatchCode());
        batchService.save(batch);
        return batchMapper.mapToDTO(batch);
    }

    @Override
    public void deleteBatch(Long id) {
        batchService.deleteById(id);
    }

}
