package com.thecodeschool.catalog.resource;

import com.thecodeschool.catalog.model.Movie;
import com.thecodeschool.catalog.model.MovieCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalog")
    public List<MovieCatalog> getCatalog() {
        List<MovieCatalog> movieCatalogs = new ArrayList<>();

//        List<Movie> movies = restTemplate.getForObject("http://localhost:8082/movie", List.class);

        /*ResponseEntity<List<Movie>> response = restTemplate.exchange(
                "http://localhost:8082/movie",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        List<Movie> movies = response.getBody();*/

        WebClient.Builder webClientBuilder = WebClient.builder();

        List<Movie> movies = webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8082/movie")
                        .retrieve()
                        .bodyToMono(List.class)
                        .block();

        movies.forEach(movie -> movieCatalogs.add(new MovieCatalog(movie, restTemplate.getForObject("http://localhost:8083/rating/"+movie.getId(), Float.class))));

        return movieCatalogs;
    }
}
