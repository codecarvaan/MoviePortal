package com.fortinet.service;


import com.fortinet.beans.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getAllMovies();

    List<Movie> getMovieByName(String movieName);

    Movie getMovieById(int movieId);

    Movie addMovie(Movie movie);

    Boolean deleteMovieById(int movieId);

    Movie updateMovie(Movie movie);

}
