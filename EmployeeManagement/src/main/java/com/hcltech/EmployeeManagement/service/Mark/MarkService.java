package com.hcltech.EmployeeManagement.service.Mark;


import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksRequestDTO;
import com.hcltech.EmployeeManagement.model.Marks;

import java.util.List;
import java.util.Optional;

public interface MarkService {

    MarksDTO addMarks(MarksRequestDTO dto);
    List<MarksDTO> getAllMarks();
    MarksDTO updateMarks(Long id,MarksRequestDTO dto);
    void deleteMarks(Long id);
}
