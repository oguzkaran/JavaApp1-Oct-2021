package org.csystem.app.service.rest.movie.data.repository;

import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

public interface IMovieRepository extends ICrudRepository<Movie, Long> {
    Iterable<Movie> findByMonth(int month);
    Iterable<Movie> findByYear(int year);
    Iterable<Movie> findByMonthAndYear(int month, int year);
    Iterable<Movie> findByYearBetween(int min, int max);
}
