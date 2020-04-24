package com.fortinet.validator;

import com.fortinet.beans.Movie;
import com.fortinet.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesValidator {
    @Autowired
    MoviesService moviesService;
    public List<Movie> validGetAllMovies() {

        List<Movie> movies=  moviesService.ServiceGetAllMovies();
        return movies;
    }

    public Movie validgetMoviesById(int movieId) {

        Movie movie=  moviesService.ServiceGetMovieById(movieId);
        return movie;
    }

    public Movie validaddMovie(Movie movie) {

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

        return moviesService.ServiceAddMovie(movie);
    }

    public Movie validUpdateMovie(Movie movie) {
        if(movie.getCategory().equals("")||movie.getCategory()==null)
            throw new RuntimeException("Movie Category Can Not be empty");
        if(movie.getName().equals("")||movie.getName()==null)
            throw new RuntimeException("Movie Name Can Not be empty");
        if(movie.getTitle().equals("")||movie.getTitle()==null)
            throw new RuntimeException("Movie Title Can Not be empty");

        if(movie.getRating()<0||movie.getRating()>5)
            throw new RuntimeException("Movie Rating Must be in the range 0-5");
        return moviesService.ServiceUpdateMovie(movie);
    }

    public boolean validgetDeleteById(int movieId) {
        return moviesService.ServiceDeleteMovieById(movieId);
    }

    public List<Movie> validgetMoviesByName(String movieName) {
        List<Movie> movie=moviesService.ServiceGetMovieByName(movieName);
        return movie;
    }
}
