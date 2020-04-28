package com.fortinet.validator;

import com.fortinet.beans.Movie;
import com.fortinet.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoviesValidator {
    @Autowired
    MoviesService moviesService;

    public List<Movie> getAllMovies() {

        List<Movie> movies = moviesService.getAllMovies();
        return movies;
    }

    public Movie getMoviesById(int movieId) {

        Movie movie = moviesService.getMovieById(movieId);
        return movie;
    }

    public Movie addMovie(Movie movie) {

        if(movie.getId()!=0)
            throw new RuntimeException(" Movie Id Should be Empty");
        if (movie.getCategory().equals("") || movie.getCategory() == null)
            throw new RuntimeException("Movie Category Can Not be empty");
        if (movie.getName().equals("") || movie.getName() == null)
            throw new RuntimeException("Movie Name Can Not be empty");
        if (movie.getTitle().equals("") || movie.getTitle() == null)
            throw new RuntimeException("Movie Title Can Not be empty");
        if (movie.getRating() == null)
            throw new RuntimeException("Movie Title Can Not be empty");
        if (movie.getRating() < 0 || movie.getRating() > 5)
            throw new RuntimeException("Movie Rating Must be in the range 0-5");

        return moviesService.addMovie(movie);
    }

    public Movie updateMovie(Movie movie) {
        if (movie.getCategory().equals("") || movie.getCategory() == null)
            throw new RuntimeException("Movie Category Can Not be empty");
        if (movie.getName().equals("") || movie.getName() == null)
            throw new RuntimeException("Movie Name Can Not be empty");
        if (movie.getTitle().equals("") || movie.getTitle() == null)
            throw new RuntimeException("Movie Title Can Not be empty");

        if (movie.getRating() < 0 || movie.getRating() > 5)
            throw new RuntimeException("Movie Rating Must be in the range 0-5");
        return moviesService.updateMovie(movie);
    }


    public boolean deleteById(int movieId) {

        return moviesService.deleteMovieById(movieId);
    }


    public List<Movie> getMoviesByName(String movieName) {
        if ( null == movieName ||movieName.equals(""))
            throw new RuntimeException("Movie Name Can Not be empty");
        List<Movie> movie = moviesService.getMovieByName(movieName);
        return movie;
    }
}
