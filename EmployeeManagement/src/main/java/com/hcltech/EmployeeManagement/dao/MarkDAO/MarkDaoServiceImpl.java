package com.hcltech.EmployeeManagement.dao.MarkDAO;


public class MarkDaoServiceImpl implements MarkDaoService{

    /*    @Override
    public MarksDTO addMarks(MarksRequestDTO dto) {
        Employee employee = employeeRepo.findById(dto.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        Exam exam = examRepo.findById(dto.getExamId())
            .orElseThrow(() -> new RuntimeException("Exam not found"));

        Marks mark = new Marks();
        mark.setEmployee(employee);
        mark.setExam(exam);
        mark.setScore(dto.getScore());

        marksRepo.save(mark);

        return mapToDTO(mark);
    }

    @Override
    public List<MarksDTO> getAllMarks() {
        return marksRepo.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteMarks(Long id) {
        marksRepo.deleteById(id);
    }

    private MarksDTO mapToDTO(Marks mark) {
        MarksDTO dto = new MarksDTO();
        dto.setExamName(mark.getExam().getName());
        dto.setScore(mark.getScore());
        return dto;
    }*/
}
