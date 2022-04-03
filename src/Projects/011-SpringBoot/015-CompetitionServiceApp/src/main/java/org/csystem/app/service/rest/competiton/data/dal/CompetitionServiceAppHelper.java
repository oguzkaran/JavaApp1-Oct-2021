package org.csystem.app.service.rest.competiton.data.dal;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.data.repository.IAuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompetitionServiceAppHelper {
    private final IAuthorRepository m_authorRepository;
    //...

    public CompetitionServiceAppHelper(IAuthorRepository authorRepository)
    {
        m_authorRepository = authorRepository;
    }

    public long authorCount()
    {
        return m_authorRepository.count();
    }

    public Optional<Author> findAuthorByEmail(String email)
    {
        return m_authorRepository.findById(email);
    }

    public Iterable<Author> findAuthorsByName(String name)
    {
        return m_authorRepository.findByName(name);
    }
}
