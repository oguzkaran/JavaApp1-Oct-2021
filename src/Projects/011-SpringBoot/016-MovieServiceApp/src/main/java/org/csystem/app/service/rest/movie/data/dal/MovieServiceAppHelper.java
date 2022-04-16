package org.csystem.app.service.rest.movie.data.dal;

import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.csystem.app.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceAppHelper {
    private final IMovieRepository m_movieRepository;

    public MovieServiceAppHelper(IMovieRepository movieRepository)
    {
        m_movieRepository = movieRepository;
    }

    public long movieCount()
    {
        return m_movieRepository.count();
    }
    public Iterable<Movie> findMoviesByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }

    //...
}
