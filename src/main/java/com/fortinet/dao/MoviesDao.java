package com.fortinet.dao;

import com.fortinet.beans.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Movie> DAOGetAllMovies() {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Movie.class);
        List<Movie> movie = cr.list();
        return movie;
    }

    public List<Movie> DAOGetMoviesByName(String MoviesName) {
        Session session = sessionFactory.getCurrentSession();
        List<Movie> movies=null;
        Criteria cr = session.createCriteria(Movie.class);
        System.out.println("MoviesName"+MoviesName);
        cr.add(Restrictions.like("name", "%"+MoviesName+"%"));
        movies =  cr.list();
        return movies;
    }

    public Movie DAOGetMovieById(int movieId) {
        Session session = sessionFactory.getCurrentSession();
        Movie movie = session.get(Movie.class, movieId);
        return movie;
    }

    public Movie DAOAddMovie(Movie movie) {
        Session session=sessionFactory.getCurrentSession();
        session.save(movie);
        return movie;
    }
    public Movie DAOUpdateMovie(Movie movie) {
        Session session=sessionFactory.getCurrentSession();
        session.update(movie);
        return movie;
    }

    public boolean DaoDeleteMovie(int movieId) {
        Session session=sessionFactory.getCurrentSession();
        Movie movie = session.get(Movie.class, movieId);
        session.delete(movie);
        return true;
    }

}
