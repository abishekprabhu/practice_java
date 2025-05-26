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
