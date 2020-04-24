package com.fortinet.service;

import com.fortinet.beans.Movie;
import com.fortinet.dao.MoviesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoviesServiceImp implements MoviesService{
    @Autowired
    private MoviesDao moviesDao;
    @Override
    public List<Movie> ServiceGetAllMovies() {

        return moviesDao.DAOGetAllMovies();
    }

    @Override
    public List<Movie> ServiceGetMovieByName(String movieName) {
       return moviesDao.DAOGetMoviesByName(movieName);
    }

    @Override
    public Movie ServiceGetMovieById(int movieId) {
        return moviesDao.DAOGetMovieById(movieId);
    }

    @Override
    public Movie ServiceAddMovie(Movie movie) {


        if(movie.getId()!=0)
            throw new RuntimeException(" Movie Id Sould be Empty");
        return moviesDao.DAOAddMovie(movie);
    }

    @Override
    public Boolean ServiceDeleteMovieById(int movieId) {
        return moviesDao.DaoDeleteMovie(movieId);
    }

    @Override
    public Movie ServiceUpdateMovie(Movie movie) {
         return moviesDao.DAOUpdateMovie(movie);
    }

}
