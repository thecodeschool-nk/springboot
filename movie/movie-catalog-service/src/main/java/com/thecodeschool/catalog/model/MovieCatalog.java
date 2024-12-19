package com.thecodeschool.catalog.model;

public class MovieCatalog {

    private Movie movie;
    private float rating;

    public MovieCatalog(Movie movie, float rating) {
        this.movie = movie;
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "MovieCatalog{" +
                "movie=" + movie +
                ", rating=" + rating +
                '}';
    }
}
