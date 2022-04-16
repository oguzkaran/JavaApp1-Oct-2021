package org.csystem.app.service.rest.movie;

import org.csystem.app.service.rest.movie.data.dal.MovieServiceAppHelper;
import org.csystem.app.service.rest.movie.dto.MoviesDTO;
import org.csystem.app.service.rest.movie.mapper.IMovieMapper;
import org.springframework.stereotype.Service;

import static org.csystem.util.collection.CollectionUtil.toIterable;
import static org.csystem.util.collection.CollectionUtil.toList;

@Service
public class MovieAppService {
    private final MovieServiceAppHelper m_movieServiceAppHelper;
    private final IMovieMapper m_movieMapper;

    public MovieAppService(MovieServiceAppHelper movieServiceAppHelper, IMovieMapper movieMapper)
    {
        m_movieServiceAppHelper = movieServiceAppHelper;
        m_movieMapper = movieMapper;
    }

    public long movieCount()
    {
        return m_movieServiceAppHelper.movieCount();
    }

    public MoviesDTO findMoviesByMonth(int month)
    {
        return m_movieMapper.toMoviesDTO(toList(m_movieServiceAppHelper.findMoviesByMonth(month), m_movieMapper::toMovieDTO));
    }

    //...
}
