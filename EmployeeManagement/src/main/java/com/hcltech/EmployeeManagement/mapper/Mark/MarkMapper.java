package com.hcltech.EmployeeManagement.mapper.Mark;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksDTO;
import com.hcltech.EmployeeManagement.dto.Mark.MarksRequestDTO;
import com.hcltech.EmployeeManagement.mapper.Batch.BatchMapper;
import com.hcltech.EmployeeManagement.model.Batch;
import com.hcltech.EmployeeManagement.model.Marks;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MarkMapper {

/*    public static MarksDTO mapToDTO(Marks mark) {
        MarksDTO dto = new MarksDTO();
        dto.setExamName(mark.getExam().getName());
        dto.setScore(mark.getScore());
        return dto;
    }*/

    MarkMapper INSTANCE = Mappers.getMapper(MarkMapper.class);

    MarksDTO toDTO(Marks mark);
    Marks toEntity(MarksRequestDTO dto);
}
