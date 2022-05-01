package org.csystem.app.service.rest.competiton.data.dal;

import org.csystem.app.service.rest.competiton.annotation.DataHelper;
import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.app.service.rest.competiton.data.repository.IAuthorRepository;

import java.util.Optional;

@DataHelper
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

    public Iterable<Author> findAllAuthors()
    {
        return m_authorRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email)
    {
        return m_authorRepository.findById(email);
    }

    public Iterable<Author> findAuthorsByName(String name)
    {
        return m_authorRepository.findByName(name);
    }

    public Iterable<Author> findAuthorsByNameContains(String text)
    {
        return m_authorRepository.findByNameContains(text);
    }

    public Iterable<Author> findAuthorsByMonthBetween(int min, int max)
    {
        return m_authorRepository.findByMonthBetween(min, max);
    }

    public Iterable<Author> findAuthorsByYearBetween(int min, int max)
    {
        return m_authorRepository.findByYearBetween(min, max);
    }

    public Iterable<Author> findAuthorsByMonthAndYear(int month, int year)
    {
        return m_authorRepository.findByMonthAndYear(month, year);
    }

    public Author saveAuthor(Author author)
    {
        return m_authorRepository.save(author);
    }
}
