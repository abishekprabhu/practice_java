package com.hcltech.EmployeeManagement.dao.MarkDAO;

import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksRequestDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.model.Marks;

import java.util.List;
import java.util.Optional;

public interface MarkDaoService {

    Marks save(Marks exam);
    Optional<Marks> findById(Long id);
    List<Marks> findAll();
    void deleteById(Long id);

}
