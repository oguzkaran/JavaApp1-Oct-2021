package org.csystem.application.service.rest.movie.data.repository;

import org.csystem.application.service.rest.movie.data.entity.Movie;
import org.csystem.application.service.rest.movie.data.entity.MovieDirectorDetail;
import org.csystem.util.data.repository.ICrudRepository;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
    Iterable<Movie> findMoviesByYear(int year);
    Iterable<MovieDirectorDetail> findMoviesDetailsByYear(int year);
    Iterable<Movie> findMoviesByMonthYear(int month, int year);
}
