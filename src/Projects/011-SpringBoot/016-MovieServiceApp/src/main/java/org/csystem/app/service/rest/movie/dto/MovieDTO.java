package org.csystem.app.service.rest.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieDTO {
    private String m_name;
    private LocalDate m_sceneDate;
    private BigDecimal m_cost;

    private long m_rating;

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

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public void setSceneDate(LocalDate sceneDate)
    {
        m_sceneDate = sceneDate;
    }

    @JsonProperty("budget")
    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }

    public long getRating()
    {
        return m_rating;
    }

    public void setRating(long rating)
    {
        m_rating = rating;
    }
}
