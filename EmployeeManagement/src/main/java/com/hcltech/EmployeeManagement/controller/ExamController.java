package com.hcltech.EmployeeManagement.controller;


import com.hcltech.EmployeeManagement.dao.ExamDAO.ExamDaoService;
import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.service.Exam.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examService/v1/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public ResponseEntity<ExamResponseDTO> create(@RequestBody ExamRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(examService.createExam(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResponseDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @GetMapping
    public ResponseEntity<List<ExamResponseDTO>> getAll(){
        return ResponseEntity.ok(examService.getAllExams());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamResponseDTO> update(@PathVariable Long id,@RequestBody ExamRequestDTO dto){
        try {
            return ResponseEntity.ok(examService.updateExam(id,dto));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        examService.deleteExam(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}