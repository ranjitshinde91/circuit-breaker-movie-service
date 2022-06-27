package com.move.movieservice.service;

import com.move.movieservice.client.MovieRecommendationClient;
import com.move.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRecommendationClient movieRecommendationClient;

    public MovieService(MovieRecommendationClient movieRecommendationClient) {
        this.movieRecommendationClient = movieRecommendationClient;
    }


    public List<Movie> movies() {
        return movieRecommendationClient.recommendedMovies();
    }
}
