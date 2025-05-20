package coder.abishekprabhu.springsample.service;

import coder.abishekprabhu.springsample.DTO.MovieDTO;
import coder.abishekprabhu.springsample.model.Movie;
import coder.abishekprabhu.springsample.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public MovieDTO createMovie(MovieDTO dto) {
        Movie movie = dtoToEntity(dto);
        Movie saved = repository.save(movie);
        return entityToDto(saved);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    // Manual Mapping Methods
    private Movie dtoToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setTitle(dto.getTitle());
        movie.setDirector(dto.getDirector());
        movie.setYear(dto.getYear());
        movie.setGenre(dto.getGenre());
        return movie;
    }

    private MovieDTO entityToDto(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setDirector(movie.getDirector());
        dto.setYear(movie.getYear());
        dto.setGenre(movie.getGenre());
        return dto;
    }
}