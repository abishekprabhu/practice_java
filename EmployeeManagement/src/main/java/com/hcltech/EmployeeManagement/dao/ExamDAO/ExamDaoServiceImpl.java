package com.hcltech.EmployeeManagement.dao.ExamDAO;

import com.hcltech.EmployeeManagement.dto.Exam.ExamRequestDTO;
import com.hcltech.EmployeeManagement.dto.Exam.ExamResponseDTO;
import com.hcltech.EmployeeManagement.model.Exam;

import java.util.List;

public class ExamDaoServiceImpl { //implements ExamDaoService {
    // Implement the methods defined in the ExamDaoService interface

//    @Autowired
//    private ExamRepository examRepo;
//
//    @Autowired
//    private BatchRepository batchRepo;

//    @Override
//    public ExamResponseDTO createExam(ExamRequestDTO dto) {
//        Batch batch = batchRepo.findById(dto.getBatchId())
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//
//        Exam exam = new Exam();
//        exam.setName(dto.getName());
//        exam.setDate(dto.getDate());
//        exam.setBatch(batch);
//        examRepo.save(exam);
//
//        return mapToDTO(exam);
//    }
//
//    @Override
//    public ExamResponseDTO getExamById(Long id) {
//        Exam exam = examRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Exam not found"));
//        return mapToDTO(exam);
//    }
//
//    @Override
//    public List<ExamResponseDTO> getAllExams() {
//        return examRepo.findAll().stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ExamResponseDTO updateExam(Long id, ExamRequestDTO dto) {
//        Exam exam = examRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Exam not found"));
//
//        Batch batch = batchRepo.findById(dto.getBatchId())
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//
//        exam.setName(dto.getName());
//        exam.setDate(dto.getDate());
//        exam.setBatch(batch);
//
//        examRepo.save(exam);
//        return mapToDTO(exam);
//    }
//
//    @Override
//    public void deleteExam(Long id) {
//        examRepo.deleteById(id);
//    }
//
//    private ExamResponseDTO mapToDTO(Exam exam) {
//        ExamResponseDTO dto = new ExamResponseDTO();
//        dto.setId(exam.getId());
//        dto.setName(exam.getName());
//        dto.setDate(exam.getDate());
//        dto.setBatchCode(exam.getBatch().getBatchCode());
//        return dto;
//    }
}
