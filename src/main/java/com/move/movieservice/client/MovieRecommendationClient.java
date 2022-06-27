package com.move.movieservice.client;

import com.move.movieservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "movieRecommendationClient", url = "http://localhost:8081")
public interface MovieRecommendationClient {

    @RequestMapping(method = RequestMethod.GET, value = "/recommendedMovies")
    List<Movie> recommendedMovies();
}
