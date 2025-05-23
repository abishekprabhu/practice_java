package com.hcltech.EmployeeManagement.dao.ExamDAO;

import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Exam;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import com.hcltech.EmployeeManagement.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamDaoServiceImpl implements ExamDaoService {
    // Implement the methods defined in the ExamDaoService interface
/*
    private final ExamRepository examRepo;

    @Autowired
    private BatchRepository batchRepo;

    @Override
    public ExamResponseDTO createExam(ExamRequestDTO dto) {
        Batch batch = batchRepo.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        Exam exam = new Exam();
        exam.setName(dto.getName());
        exam.setDate(dto.getDate());
        exam.setBatch(batch);
        examRepo.save(exam);

        return mapToDTO(exam);
    }

    @Override
    public ExamResponseDTO getExamById(Long id) {
        Exam exam = examRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        return mapToDTO(exam);
    }

    @Override
    public List<ExamResponseDTO> getAllExams() {
        return examRepo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExamResponseDTO updateExam(Long id, ExamRequestDTO dto) {
        Exam exam = examRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        Batch batch = batchRepo.findById(dto.getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        exam.setName(dto.getName());
        exam.setDate(dto.getDate());
        exam.setBatch(batch);

        examRepo.save(exam);
        return mapToDTO(exam);
    }

    @Override
    public void deleteExam(Long id) {
        examRepo.deleteById(id);
    }

    private ExamResponseDTO mapToDTO(Exam exam) {
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setDate(exam.getDate());
        dto.setBatchCode(exam.getBatch().getBatchCode());
        return dto;
    }
*/


    private final ExamRepository examRepository;


    @Override
    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Optional<Exam> findById(Long id) {
        return examRepository.findById(id);
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }

    @Override
    public List<Exam> findByBatchId(Long batchId) {
        return examRepository.findByBatchId(batchId);
    }
}
