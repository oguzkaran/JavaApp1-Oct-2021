package org.csystem.app.service.rest.movie.dto;

import java.time.LocalDate;

public class MovieSaveDTO {
    private long m_id;
    private String m_name;
    private LocalDate m_sceneDate;
    private String m_cost;

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

    public String getCost()
    {
        return m_cost;
    }

    public void setCost(String cost)
    {
        m_cost = cost;
    }
}
