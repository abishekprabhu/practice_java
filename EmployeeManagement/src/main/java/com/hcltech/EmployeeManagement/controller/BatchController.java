package com.hcltech.EmployeeManagement.controller;

import com.hcltech.EmployeeManagement.dao.BatchDAO.BatchDaoService;
import com.hcltech.EmployeeManagement.dao.EmployeeDAO.EmployeeDaoService;
import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeRequestDTO;
import com.hcltech.EmployeeManagement.dto.Employee.EmployeeResponseDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.service.Batch.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batchService/v1/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<BatchDTO> create(@RequestBody BatchDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(batchService.createBatch(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(batchService.getBatchById(id));
    }

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAll(){
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BatchDTO> update(@PathVariable Long id,@RequestBody BatchDTO dto){
        try {
            return ResponseEntity.ok(batchService.updateBatch(id,dto));
/*        }catch(ExpenseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());*/
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        batchService.deleteBatch(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/by-batch-exam-wise")
    public ResponseEntity<List<BatchExamScoreDTO>> getMarksByBatchExamWiseSorted(){
        return ResponseEntity.ok(batchService.getMarksByBatchExamWiseSorted());
    }

}
