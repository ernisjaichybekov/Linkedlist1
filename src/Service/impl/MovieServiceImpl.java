package Service.impl;

import Service.MovieService;

import Service.MovieSortService;
import enums.Genre;
import model.Movie;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    private List<Movie> movies;

    public MovieServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        return movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }
    @Override
    public Movie findMovieByActorName(String actorName) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getActorFullName().equalsIgnoreCase(actorName)))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        return movies.stream()
                .filter(movie -> movie.getYear().equals(year))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        return movies.stream()
                .filter(movie -> movie.getProducer().getFullName().equalsIgnoreCase(producerFullName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre() == genre)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Movie findMovieByRole(String role) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getRole().equalsIgnoreCase(role)))
                .findFirst()
                .orElse(null);
    }
}

