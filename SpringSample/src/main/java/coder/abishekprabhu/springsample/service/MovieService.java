package coder.abishekprabhu.springsample.service;

import coder.abishekprabhu.springsample.DTO.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO createMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
}
