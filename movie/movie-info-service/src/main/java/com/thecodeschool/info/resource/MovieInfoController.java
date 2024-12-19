package com.thecodeschool.info.resource;

import com.thecodeschool.info.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieInfoController {

    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return List.of(
                new Movie(1, "A", "aa"),
                new Movie(2, "B", "bb")
        );
    }
}
