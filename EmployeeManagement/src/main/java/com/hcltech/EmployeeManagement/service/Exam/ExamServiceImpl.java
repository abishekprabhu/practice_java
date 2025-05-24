package com.hcltech.EmployeeManagement.service.Exam;

import com.hcltech.EmployeeManagement.dao.BatchDAO.BatchDaoService;
import com.hcltech.EmployeeManagement.dao.ExamDAO.ExamDaoService;
import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.mapper.Exam.ExamMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{

    private final ExamDaoService examDaoService;
    private final BatchDaoService batchDaoService;
    private final ExamMapper examMapper;


    @Override
    public ExamResponseDTO createExam(ExamRequestDTO dto) {
        Batch batch = batchDaoService.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        Exam exam = new Exam();
        exam.setName(dto.getName());
        exam.setDate(dto.getDate());
        exam.setBatch(batch);
        examDaoService.save(exam);

        return examMapper.mapToDTO(exam);
    }

    @Override
    public ExamResponseDTO getExamById(Long id) {
        Exam exam = examDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        return examMapper.mapToDTO(exam);
    }

    @Override
    public List<ExamResponseDTO> getAllExams() {
        return examDaoService.findAll().stream()
                .map(examMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExamResponseDTO updateExam(Long id, ExamRequestDTO dto) {
        Exam exam = examDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        Batch batch = batchDaoService.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        exam.setName(dto.getName());
        exam.setDate(dto.getDate());
        exam.setBatch(batch);

        examDaoService.save(exam);
        return examMapper.mapToDTO(exam);
    }

    @Override
    public void deleteExam(Long id) {
        examDaoService.deleteById(id);
    }


}
