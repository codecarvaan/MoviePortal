package com.fortinet.service;

import com.fortinet.beans.Movie;
import com.fortinet.dao.MoviesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoviesServiceImp implements MoviesService {
    @Autowired
    private MoviesDao moviesDao;

    public void setMovieDao(MoviesDao movieDao) {
        this.moviesDao = movieDao;
    }

    @Override
    public List<Movie> getAllMovies() {

        return moviesDao.DAOGetAllMovies();
    }

    @Override
    public List<Movie> getMovieByName(String movieName) {
        return moviesDao.DAOGetMoviesByName(movieName);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return moviesDao.DAOGetMovieById(movieId);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return moviesDao.DAOAddMovie(movie);
    }

    @Override
    public Boolean deleteMovieById(int movieId) {
        return moviesDao.DaoDeleteMovie(movieId);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return moviesDao.DAOUpdateMovie(movie);
    }

}
