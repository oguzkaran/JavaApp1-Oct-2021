package org.csystem.application.rest.todo.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private long m_id;

    @Column(name = "title", length = 128, nullable = false)
    private String m_title;

    @Column(name = "text", length = 512)
    private String m_text;

    @Column(name = "insert_date_time", nullable = false)
    private LocalDateTime m_insertDateTime = LocalDateTime.now();

    @Column(name = "last_update", nullable = false)
    private LocalDateTime m_lastUpdate = m_insertDateTime;

    @Column(name = "completed", nullable = false)
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

    public LocalDateTime getInsertDateTime()
    {
        return m_insertDateTime;
    }

    public void setInsertDateTime(LocalDateTime insertDateTime)
    {
        m_insertDateTime = insertDateTime;
    }

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
