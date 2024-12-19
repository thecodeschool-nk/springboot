package com.thecodeschool.rating.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRatingController {

    @GetMapping("/rating/{movieId}")
    public float getRating(@PathVariable("movieId") int movieId) {
        return 4.0f;
    }
}
