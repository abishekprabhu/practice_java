package coder.abishekprabhu.springsample.service;

import coder.abishekprabhu.springsample.DTO.MovieDTO;
import coder.abishekprabhu.springsample.mapper.MovieMapper;
import coder.abishekprabhu.springsample.model.Movie;
import coder.abishekprabhu.springsample.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;


    @Override
    public MovieDTO createMovie(MovieDTO dto) {

//        Movie movie = new Movie();
//        movie.setId(dto.getId());
//        movie.setYear(dto.getYear());
//        movie.setDirector(dto.getDirector());
//        return movieRepository.save(movie); //return type is Movie

        Movie movie = movieMapper.toEntity(dto);
        return movieMapper.toDTO(movieRepository.save(movie));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieMapper.toDTOs(movieRepository.findAll());
    }

}
