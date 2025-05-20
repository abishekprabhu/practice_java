package coder.abishekprabhu.springsample.mapper;

import coder.abishekprabhu.springsample.DTO.MovieDTO;
import coder.abishekprabhu.springsample.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toEntity(MovieDTO dto);
    MovieDTO toDTO(Movie entity);
    List<MovieDTO> toDTOs(List<Movie> entities);
}
