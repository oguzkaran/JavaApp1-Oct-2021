package org.csystem.app.service.rest.movie.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie {
    private long m_id;
    private String m_name;
    private LocalDate m_sceneDate;
    private long m_rating;
    private BigDecimal m_cost;
    private double m_imdb;

    public Movie(long id, String name, LocalDate sceneDate, long rating, BigDecimal cost, double imdb)
    {
        m_id = id;
        m_name = name;
        m_sceneDate = sceneDate;
        m_rating = rating;
        m_cost = cost;
        m_imdb = imdb;
    }

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public LocalDate getSceneDate()
    {
        return m_sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate)
    {
        m_sceneDate = sceneDate;
    }

    public long getRating()
    {
        return m_rating;
    }

    public void setRating(long rating)
    {
        m_rating = rating;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public double getImdb()
    {
        return m_imdb;
    }

    public void setImdb(double imdb)
    {
        m_imdb = imdb;
    }
}
