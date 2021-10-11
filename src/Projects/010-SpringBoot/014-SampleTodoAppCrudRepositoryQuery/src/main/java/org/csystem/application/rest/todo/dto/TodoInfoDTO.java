package org.csystem.application.rest.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TodoInfoDTO {
    private long m_id;
    private String m_title;
    private String m_text;
    private LocalDateTime m_insertDateTime;
    private LocalDateTime m_lastUpdate;
    private boolean m_completed;

    public long getId()
    {
        return m_id;
    }

    public void setId(long id)
    {
        m_id = id;
    }

    public String getTitle()
    {
        return m_title;
    }

    public void setTitle(String title)
    {
        m_title = title;
    }

    public String getText()
    {
        return m_text;
    }

    public void setText(String text)
    {
        m_text = text;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getInsertDateTime()
    {
        return m_insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime)
    {
        m_insertDateTime = insertDateTime;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    public LocalDateTime getLastUpdate()
    {
        return m_lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate)
    {
        m_lastUpdate = lastUpdate;
    }

    public boolean isCompleted()
    {
        return m_completed;
    }

    public void setCompleted(boolean completed)
    {
        m_completed = completed;
    }
}
