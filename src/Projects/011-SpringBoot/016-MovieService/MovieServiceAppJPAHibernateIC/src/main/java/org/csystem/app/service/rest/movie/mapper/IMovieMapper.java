package org.csystem.app.service.rest.movie.mapper;

import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.csystem.app.service.rest.movie.dto.MovieDTO;
import org.csystem.app.service.rest.movie.dto.MovieSaveDTO;
import org.csystem.app.service.rest.movie.dto.MoviesDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper {
    MovieDTO toMovieDTO(Movie movie);
    Movie toMovie(MovieSaveDTO movieSaveDTO);
    MovieSaveDTO toMovieSaveDTO(Movie movie);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movieDTOS)
    {
        var dto = new MoviesDTO();

        dto.setMovies(movieDTOS);

        return dto;
    }
}
