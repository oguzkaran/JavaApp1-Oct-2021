package org.csystem.app.service.rest.competiton.dto;

import java.util.List;

public class AuthorsDetailDTO {
    private List<AuthorDetailDTO> m_authors;

    public List<AuthorDetailDTO> getAuthors()
    {
        return m_authors;
    }

    public void setAuthors(List<AuthorDetailDTO> authors)
    {
        m_authors = authors;
    }
}
