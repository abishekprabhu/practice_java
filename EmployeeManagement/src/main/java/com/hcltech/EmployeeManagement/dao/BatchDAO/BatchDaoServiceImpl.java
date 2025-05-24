package com.hcltech.EmployeeManagement.dao.BatchDAO;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.ExamScoreDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.ScoreDTO;
import com.hcltech.EmployeeManagement.mapper.Batch.BatchMapper;
//import com.hcltech.EmployeeManagement.mapper.Employee.EmployeeMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Marks;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import com.hcltech.EmployeeManagement.service.Batch.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatchDaoServiceImpl implements BatchDaoService {

    private final BatchRepository batchRepository;

    @Override
    public void save(Batch batch) {
        batchRepository.save(batch);
    }

    @Override
    public Optional<Batch> findById(Long id) {
        return batchRepository.findById(id);
    }

    @Override
    public List<Batch> findAll() {
        return batchRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        batchRepository.deleteById(id);
    }

}
