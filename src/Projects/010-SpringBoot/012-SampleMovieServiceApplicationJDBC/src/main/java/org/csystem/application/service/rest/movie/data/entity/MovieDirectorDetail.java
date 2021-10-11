/*
    MovieDirectorDetail şeklindeki tasarım özellikle gösterilmiştir. Bu bir yaklaşımdır. Değişebilir
*/
package org.csystem.application.service.rest.movie.data.entity;

public class MovieDirectorDetail {
    private Movie m_movie;
    private Director m_director;

    public MovieDirectorDetail(Movie movie, Director director)
    {
        m_movie = movie;
        m_director = director;
    }

    public Movie getMovie()
    {
        return m_movie;
    }

    public void setMovie(Movie movie)
    {
        m_movie = movie;
    }

    public Director getDirector()
    {
        return m_director;
    }

    public void setDirector(Director director)
    {
        m_director = director;
    }
}
