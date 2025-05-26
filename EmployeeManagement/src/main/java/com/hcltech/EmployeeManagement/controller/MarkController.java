package com.hcltech.EmployeeManagement.controller;


import com.hcltech.EmployeeManagement.dao.MarkDAO.MarkDaoService;
import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksRequestDTO;
import com.hcltech.EmployeeManagement.service.Mark.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/markService/v1/mark")
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;

    @PostMapping
    public ResponseEntity<MarksDTO> create(@RequestBody MarksRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(markService.addMarks(dto));
    }

    @GetMapping
    public ResponseEntity<List<MarksDTO>> getAll(){
        return ResponseEntity.ok(markService.getAllMarks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarksDTO> update(@PathVariable Long id,@RequestBody MarksRequestDTO dto){
        try {
            return ResponseEntity.ok(markService.updateMarks(id,dto));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        markService.deleteMarks(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
