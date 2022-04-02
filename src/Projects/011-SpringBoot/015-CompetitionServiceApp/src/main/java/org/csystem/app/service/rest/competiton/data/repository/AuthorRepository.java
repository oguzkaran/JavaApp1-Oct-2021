package org.csystem.app.service.rest.competiton.data.repository;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorRepository implements IAuthorRepository {
    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    public AuthorRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }


    /////////////////////////////////////////////////////////////////////////
    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Author author)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Author> authors)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Author> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Author> findAllById(Iterable<Integer> integers)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Author> findById(Integer integer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Author> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Author> Iterable<S> save(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
