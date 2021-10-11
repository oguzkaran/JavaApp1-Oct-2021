package org.csystem.application.service.rest.movie.converter;

import org.csystem.application.service.rest.movie.data.entity.MovieDirectorDetail;
import org.csystem.application.service.rest.movie.dto.MovieDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieDirectorConverter {
    private final MovieConverter m_movieConverter;
    private final DirectorConverter m_directorConverter;

    public MovieDirectorConverter(MovieConverter movieConverter, DirectorConverter directorConverter)
    {
        m_movieConverter = movieConverter;
        m_directorConverter = directorConverter;
    }

    public MovieDetailDTO toMovieDetailDTO(MovieDirectorDetail detail)
    {
        var movieDetailDTO = new MovieDetailDTO();

        movieDetailDTO.setMovieDTO(m_movieConverter.toMovieDTO(detail.getMovie()));
        movieDetailDTO.setDirectorName(m_directorConverter.toDirectorDTO(detail.getDirector()).getName());

        return movieDetailDTO;
    }
}
