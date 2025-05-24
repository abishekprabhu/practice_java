package com.hcltech.EmployeeManagement.service.Mark;

import com.hcltech.EmployeeManagement.dao.EmployeeDAO.EmployeeDaoService;
import com.hcltech.EmployeeManagement.dao.ExamDAO.ExamDaoService;
import com.hcltech.EmployeeManagement.dao.MarkDAO.MarkDaoService;
import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksRequestDTO;
import com.hcltech.EmployeeManagement.mapper.Mark.MarkMapper;
import com.hcltech.EmployeeManagement.model.Employee;
import com.hcltech.EmployeeManagement.model.Exam;
import com.hcltech.EmployeeManagement.model.Marks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {


    private final MarkDaoService markDaoService;

    private final EmployeeDaoService employeeDaoService;

    private final ExamDaoService examDaoService;

    private final MarkMapper markMapper;

    @Override
    public MarksDTO addMarks(MarksRequestDTO dto) {
        Employee employee = employeeDaoService.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Exam exam = examDaoService.findById(dto.getExamId()).orElseThrow(()-> new RuntimeException());

        Marks mark = markMapper.toEntity(dto);

        markDaoService.save(mark);

        return markMapper.toDTO(mark);
    }

    @Override
    public List<MarksDTO> getAllMarks() {
        return markDaoService.findAll().stream()
                .map(markMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarksDTO updateMarks(Long id,MarksRequestDTO dto) {
        Employee employee = employeeDaoService.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Exam exam = examDaoService.findById(dto.getExamId())
                .orElseThrow(RuntimeException::new);

        Marks mark = markDaoService.findById(id)
                .orElseThrow(RuntimeException::new);
        mark.setEmployee(employee);
        mark.setExam(exam);
        mark.setScore(dto.getScore());

        markDaoService.save(mark);

        return markMapper.toDTO(mark);
    }

    @Override
    public void deleteMarks(Long id) {
        markDaoService.deleteById(id);
    }


/*    private MarksDTO mapToDTO(Marks mark) {
        MarksDTO dto = new MarksDTO();
        dto.setExamName(mark.getExam().getName());
        dto.setScore(mark.getScore());
        return dto;
    }*/
}
