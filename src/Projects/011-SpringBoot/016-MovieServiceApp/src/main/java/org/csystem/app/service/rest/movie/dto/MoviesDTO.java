package org.csystem.app.service.rest.movie.dto;

import org.csystem.app.service.rest.movie.data.entity.Movie;

import java.util.List;

public class MoviesDTO {
    private List<MovieDTO> m_movies;

    public List<MovieDTO> getMovies()
    {
        return m_movies;
    }

    public void setMovies(List<MovieDTO> movies)
    {
        m_movies = movies;
    }
}
