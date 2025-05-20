package coder.abishekprabhu.springsample.controller;

import coder.abishekprabhu.springsample.DTO.MovieDTO;
import coder.abishekprabhu.springsample.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public MovieDTO create(@RequestBody MovieDTO dto){
        return movieService.createMovie(dto);
    }

    @GetMapping
    public List<MovieDTO> getAll(){
        return movieService.getAllMovies();
    }
    
}
