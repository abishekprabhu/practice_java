package com.hcltech.EmployeeManagement.service.Batch;

import com.hcltech.EmployeeManagement.dao.BatchDAO.BatchDaoService;
import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.BatchExamScoreDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.ExamScoreDTO;
import com.hcltech.EmployeeManagement.dto.Mark.Score.ScoreDTO;
import com.hcltech.EmployeeManagement.mapper.Batch.BatchMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Marks;
import com.hcltech.EmployeeManagement.repository.BatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {
    private final BatchDaoService batchDaoService;

    private final BatchMapper batchMapper;

    @Override
    public BatchDTO createBatch(BatchDTO dto) {
//        Batch batch = new Batch();
//        batch.setBatchCode(dto.getBatchCode());
        Batch batch = batchMapper.toEntity(dto);
        batchDaoService.save(batch);
        return batchMapper.toDTO(batch);
    }

    @Override
    public BatchDTO getBatchById(Long id) {
        Batch batch = batchDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        return batchMapper.toDTO(batch);
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        return batchDaoService.findAll().stream()
                .map(batchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BatchDTO updateBatch(Long id, BatchDTO dto) {
        Batch batch = batchDaoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found"));

        batch.setBatchCode(dto.getBatchCode());
        batchDaoService.save(batch);
        return batchMapper.toDTO(batch);
    }

    @Override
    public void deleteBatch(Long id) {
        log.warn("DELETED BATCH ID : {}", id);
        batchDaoService.deleteById(id);
    }

    @Override
    public List<BatchExamScoreDTO> getMarksByBatchExamWiseSorted() {
        return batchDaoService.findAll().stream().map(
                batch -> {
                    BatchExamScoreDTO batchExamScoreDTO = new BatchExamScoreDTO();
                    batchExamScoreDTO.setBatchCode(batch.getBatchCode());

                    List<ExamScoreDTO> examScoreDTOS = batch.getExams().stream().map(exam -> {
                        ExamScoreDTO examScoreDTO = new ExamScoreDTO();
                        examScoreDTO.setExamDate(exam.getDate());
                        examScoreDTO.setExamName(exam.getName());

                        List<ScoreDTO> scoreDTOList = exam.getMarks().stream()
                                .sorted(Comparator.comparingInt(Marks::getScore).reversed())
                                .map(marks -> {
                                    ScoreDTO scoreDTO = new ScoreDTO();
                                    scoreDTO.setEmployeeName(marks.getEmployee().getName());
                                    scoreDTO.setScore(marks.getScore());
                                    return scoreDTO;
                                }).toList();

                        examScoreDTO.setScores(scoreDTOList);
                        return examScoreDTO;
                    }).toList();

                    batchExamScoreDTO.setExams(examScoreDTOS);
                    log.info("BATCH EXAM SCORE : {}", batchExamScoreDTO);
                    return batchExamScoreDTO;
                }
        ).toList();
    }
}
