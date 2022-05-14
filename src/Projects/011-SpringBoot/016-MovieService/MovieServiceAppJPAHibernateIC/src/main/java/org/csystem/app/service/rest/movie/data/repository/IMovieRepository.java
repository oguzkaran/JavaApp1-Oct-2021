package org.csystem.app.service.rest.movie.data.repository;

import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Long> {

}
