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

//    private final  BatchService batchService;
//
//    private final BatchMapper batchMapper;
//
//    @Override
//    public BatchDTO createBatch(BatchDTO dto) {
//        Batch batch = new Batch();
//        batch.setBatchCode(dto.getBatchCode());
//        batchService.save(batch);
//        return batchMapper.mapToDTO(batch);
//    }
//
//    @Override
//    public BatchDTO getBatchById(Long id) {
//        Batch batch = batchService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//        return batchMapper.mapToDTO(batch);
//    }
//
//    @Override
//    public List<BatchDTO> getAllBatches() {
//        return batchService.findAll().stream()
//                .map(batchMapper::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public BatchDTO updateBatch(Long id, BatchDTO dto) {
//        Batch batch = batchService.findById(id)
//                .orElseThrow(() -> new RuntimeException("Batch not found"));
//
//        batch.setBatchCode(dto.getBatchCode());
//        batchService.save(batch);
//        return batchMapper.mapToDTO(batch);
//    }
//
//    @Override
//    public void deleteBatch(Long id) {
//        batchService.deleteById(id);
//    }
//
//    @Override
//    public List<BatchExamScoreDTO> getMarksByBatchExamWiseSorted() {
//        return batchService.findAll().stream().map(
//                batch -> {
//                    BatchExamScoreDTO batchExamScoreDTO = new BatchExamScoreDTO();
//                    batchExamScoreDTO.setBatchCode(batch.getBatchCode());
//
//                    List<ExamScoreDTO> examScoreDTOS = batch.getExams().stream().map(exam -> {
//                        ExamScoreDTO examScoreDTO = new ExamScoreDTO();
//                        examScoreDTO.setExamDate(exam.getDate());
//                        examScoreDTO.setExamName(exam.getName());
//
//                        List<ScoreDTO> scoreDTOList = exam.getMarks().stream()
//                                .sorted(Comparator.comparingInt(Marks::getScore).reversed())
//                                .map(marks -> {
//                                    ScoreDTO scoreDTO = new ScoreDTO();
//                                    scoreDTO.setEmployeeName(marks.getEmployee().getName());
//                                    scoreDTO.setScore(marks.getScore());
//                                    return scoreDTO;
//                                }).toList();
//
//                        examScoreDTO.setScores(scoreDTOList);
//                        return examScoreDTO;
//                    }).toList();
//
//                    batchExamScoreDTO.setExams(examScoreDTOS);
//                    return batchExamScoreDTO;
//                }
//        ).toList();
//    }

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
