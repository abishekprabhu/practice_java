package com.hcltech.EmployeeManagement.mapper.Batch;

import com.hcltech.EmployeeManagement.dto.Batch.BatchDTO;
import com.hcltech.EmployeeManagement.model.Batch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

//@Component
@Mapper(componentModel = "spring")
public interface BatchMapper {

/*    public BatchDTO mapToDTO(Batch batch) {
        BatchDTO dto = new BatchDTO();
        dto.setId(batch.getId());
        dto.setBatchCode(batch.getBatchCode());
        return dto;
    }*/
    BatchMapper INSTANCE = Mappers.getMapper(BatchMapper.class);

//    @Mapping(source = "batch.id", target = "id")
//    @Mapping(source = "batch.batchCode", target = "batchCode")
    BatchDTO toDTO(Batch batch);

//    @Mapping(source = "dto.id", target = "id")
//    @Mapping(source = "dto.batchCode", target = "batchCode")
    Batch toEntity(BatchDTO dto);
}