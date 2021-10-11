package org.csystem.application.rest.todo.dto;

public class ItemSaveDTO {
    private long m_todoId;
    private String m_text;

    public long getTodoId()
    {
        return m_todoId;
    }

    public void setTodoId(long todoId)
    {
        m_todoId = todoId;
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
