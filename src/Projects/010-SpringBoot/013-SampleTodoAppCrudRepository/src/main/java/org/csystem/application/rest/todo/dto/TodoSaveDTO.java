package org.csystem.application.rest.todo.dto;

public class TodoSaveDTO {
    private String m_title;
    private String m_text;

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
}
