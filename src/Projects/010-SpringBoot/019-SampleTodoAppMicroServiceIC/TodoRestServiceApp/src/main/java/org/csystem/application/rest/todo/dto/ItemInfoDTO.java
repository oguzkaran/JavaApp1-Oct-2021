package org.csystem.application.rest.todo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ItemInfoDTO {
    private String m_text;
    private LocalDateTime m_insertDateTime = LocalDateTime.now();
    private LocalDateTime m_lastUpdate;

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
        return completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public boolean completed;
}
