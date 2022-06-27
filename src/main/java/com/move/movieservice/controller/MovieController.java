package com.move.movieservice.controller;

import com.move.movieservice.model.Movie;
import com.move.movieservice.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public List<Movie> movies() {
        return movieService.movies();
    }
}
