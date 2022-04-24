package org.csystem.app.service.rest.movie.service;

import org.csystem.app.service.rest.movie.data.dal.MovieServiceAppHelper;
import org.csystem.app.service.rest.movie.dto.DirectorsDetailDTO;
import org.csystem.app.service.rest.movie.dto.MovieSaveDTO;
import org.csystem.app.service.rest.movie.dto.MoviesDTO;
import org.csystem.app.service.rest.movie.mapper.IDirectorMapper;
import org.csystem.app.service.rest.movie.mapper.IMovieMapper;
import org.springframework.stereotype.Service;

import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class MovieAppService {
    private final MovieServiceAppHelper m_movieServiceAppHelper;
    private final IMovieMapper m_movieMapper;

    private final IDirectorMapper m_directorMapper;

    public MovieAppService(MovieServiceAppHelper movieServiceAppHelper, IMovieMapper movieMapper, IDirectorMapper directorMapper)
    {
        m_movieServiceAppHelper = movieServiceAppHelper;
        m_movieMapper = movieMapper;
        m_directorMapper = directorMapper;
    }

    public long movieCount()
    {
        return m_movieServiceAppHelper.movieCount();
    }

    public MoviesDTO findMoviesByMonth(int month)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByMonth(month), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByYear(int year)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByYear(year), m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByMonthAndYear(int month, int year)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByMonthAndYear(month, year),
                m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByYearBetween(int begin, int end)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByYearBetween(begin, end),
                m_movieMapper::toMovieDTO));
    }

    public MoviesDTO findMoviesByDirectorId(long directorId)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findByDirectorId(directorId),
                m_movieMapper::toMovieDTO));
    }

    public MovieSaveDTO saveMovie(MovieSaveDTO movieSaveDTO)
    {
        return m_movieMapper.toMovieSaveDTO(m_movieServiceAppHelper.saveMovie(m_movieMapper.toMovie(movieSaveDTO)));
    }

    public DirectorsDetailDTO findAllDirectorsDetail()
    {
        return m_directorMapper.toDirectorsDetail(toList( m_movieServiceAppHelper.findAllDirectorsDetail(),
                m_directorMapper::toDirectorDetailDTO));
    }

    public DirectorsDetailDTO findAllDirectorsDetailByMovieId(long movieId)
    {
        return m_directorMapper.toDirectorsDetail(toList( m_movieServiceAppHelper.findDirectorsDetailByMovieId(movieId),
                m_directorMapper::toDirectorDetailDTO));
    }

    //...
}
