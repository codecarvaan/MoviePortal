package com.fortinet.service;


import com.fortinet.beans.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> ServiceGetAllMovies();

    List<Movie> ServiceGetMovieByName(String movieName);

    Movie ServiceGetMovieById(int movieId);

    Movie ServiceAddMovie(Movie movie);

    Boolean ServiceDeleteMovieById(int movieId);

    Movie ServiceUpdateMovie(Movie movie);
}
