package com.hcltech.EmployeeManagement.dao.MarkDAO;

import com.hcltech.EmployeeManagement.model.Marks;
import com.hcltech.EmployeeManagement.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarkDaoServiceImpl implements MarkDaoService{

    private final MarkRepository markRepository;
    @Override
    public Marks save(Marks exam) {
        return markRepository.save(exam);
    }

    @Override
    public Optional<Marks> findById(Long id) {
        return markRepository.findById(id);
    }

    @Override
    public List<Marks> findAll() {
        return markRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        markRepository.deleteById(id);
    }


}
