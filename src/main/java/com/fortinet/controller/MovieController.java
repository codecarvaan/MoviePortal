package com.fortinet.controller;

import com.fortinet.beans.Movie;
import com.fortinet.validator.MoviesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = {"Api/Movies"})
public class MovieController {
    @Autowired
    MoviesValidator moviesValidator;

    @GetMapping(value = "/status", headers = "Accept=application/json")
    public String getStatus() {
        return "Movie API Running";
    } //To check application status

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies() {
        return moviesValidator.validGetAllMovies();
    } //To get all the movies

    //To get all the movies with particular Id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieById(@PathVariable("id") int MovieId) {
        return moviesValidator.validgetMoviesById(MovieId);
    }

    //To get all the movies with Movie name like input
    @GetMapping(value = "/Name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieByName(@PathVariable("name") String MovieName) {
        return moviesValidator.validgetMoviesByName(MovieName);
    }

    //To get all the movies with Movie name like input
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteMovieById(@PathVariable("id") int MovieId) {
        return moviesValidator.validgetDeleteById(MovieId);
    }

    //To add new Movie
    @PostMapping(value = "/addMovie", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie addMovie(@RequestBody Movie movie) {
        return moviesValidator.validaddMovie(movie);
    }
    //To update existing movie with partiular id
    @PostMapping(value = "/updateMovie", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie updateMovie(@RequestBody Movie movie) {
        return moviesValidator.validUpdateMovie(movie);
    }


}
