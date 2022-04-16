package org.csystem.app.service.rest.movie.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovieDTO {
    private String m_name;
    private LocalDate m_sceneDate;
    private BigDecimal m_cost;

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

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public void setCost(BigDecimal cost)
    {
        m_cost = cost;
    }
}
