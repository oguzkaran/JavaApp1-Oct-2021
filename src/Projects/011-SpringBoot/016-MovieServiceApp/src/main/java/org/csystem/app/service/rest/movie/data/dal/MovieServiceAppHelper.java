package org.csystem.app.service.rest.movie.data.dal;

import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.csystem.app.service.rest.movie.data.repository.IDirectorRepository;
import org.csystem.app.service.rest.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceAppHelper {
    private final IMovieRepository m_movieRepository;
    private final IDirectorRepository m_directorRepository;

    public MovieServiceAppHelper(IMovieRepository movieRepository, IDirectorRepository directorRepository)
    {
        m_movieRepository = movieRepository;
        m_directorRepository = directorRepository;
    }

    public long movieCount()
    {
        return m_movieRepository.count();
    }
    public Iterable<Movie> findMoviesByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }
    public Iterable<Movie> findMoviesByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }
    public Iterable<Movie> findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieRepository.findByMonthAndYear(month, year);
    }

    public Iterable<Movie> findMoviesByYearBetween(int begin, int end)
    {
        return m_movieRepository.findByYearBetween(begin, end);
    }

    public  Movie saveMovie(Movie movie)
    {
        return m_movieRepository.save(movie);
    }

    //...
}
