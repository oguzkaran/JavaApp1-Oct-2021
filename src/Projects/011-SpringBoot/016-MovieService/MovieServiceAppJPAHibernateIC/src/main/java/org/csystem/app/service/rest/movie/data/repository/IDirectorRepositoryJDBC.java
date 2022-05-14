package org.csystem.app.service.rest.movie.data.repository;

import org.csystem.app.service.rest.movie.data.entity.Director;
import org.csystem.app.service.rest.movie.data.entity.DirectorDetail;
import org.csystem.util.data.repository.ICrudRepository;

public interface IDirectorRepositoryJDBC extends ICrudRepository<Director, Long> {
    Iterable<DirectorDetail> findAllDetail();
    Iterable<DirectorDetail> findDetailByMovieId(long movieId);
}
