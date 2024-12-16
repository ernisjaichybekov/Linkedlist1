package Service.impl;


import Service.MovieSortService;
import model.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieSortServiceImpl implements MovieSortService  {

    private List<Movie> movies;

    public MovieSortServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void sortMovieByName(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::getName));
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(movies);
        }
        movies.forEach(System.out::println);
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        movies.sort(Comparator.comparing(Movie::getYear));
        if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.reverse(movies);
        }
        movies.forEach(System.out::println);
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        movies.sort(Comparator.comparing(movie -> {
            if (nameOrLastName.equalsIgnoreCase("name")) {
                return movie.getProducer().getFullName().split(" ")[0];
            } else {
                return movie.getProducer().getFullName().split(" ")[1];
            }
        }));
        movies.forEach(System.out::println);
}
}