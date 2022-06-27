package com.move.movieservice.service;

import com.move.movieservice.client.MovieRecommendationClient;
import com.move.movieservice.model.Movie;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRecommendationClient movieRecommendationClient;

    public MovieService(MovieRecommendationClient movieRecommendationClient) {
        this.movieRecommendationClient = movieRecommendationClient;
    }

    @CircuitBreaker(name = "movie-recommendation-service", fallbackMethod = "moviesReleasedLastYear")
    public List<Movie> movies() {
        return movieRecommendationClient.recommendedMovies();
    }

    private List<Movie> moviesReleasedLastYear(Exception e) {
        e.printStackTrace();
        return List.of(
                new Movie("Jurassic World: Dominion", "10 Nune 2022")
        );
    }
}
