package org.csystem.app.service.rest.competiton.data.repository;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class AuthorRepository implements IAuthorRepository {
    private static final String COUNT_SQL = "select count(*) from authors";
    private static final String FIND_BY_EMAIL_SQL = "select * from authors where email = :email";
    private static final String FIND_BY_NAME_SQL = "select * from authors where name = :name";
    private static final String FIND_BY_MONTH_BETWEEN = "select * from authors where date_part('month', register_date) between :min and :max";
    private static final String FIND_BY_YEAR_BETWEEN = "select * from authors where date_part('year', register_date) between :min and :max";

    private static void fillCount(ResultSet rs, ArrayList<Long> counts) throws SQLException
    {
        counts.add(rs.getLong(1));
    }

    private static void fillAuthor(ResultSet rs, ArrayList<Author> authors) throws SQLException
    {
        do
            authors.add(new Author(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate()));
        while (rs.next());
    }


    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    public AuthorRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_jdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> fillCount(rs, counts));

        return counts.get(0);
    }


    @Override
    public Optional<Author> findById(String email)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("email", email);
        var authors = new ArrayList<Author>();

        m_jdbcTemplate.query(FIND_BY_EMAIL_SQL, map, (ResultSet rs) -> fillAuthor(rs, authors));

        return authors.isEmpty() ? Optional.empty() : Optional.of(authors.get(0));
    }

    @Override
    public Iterable<Author> findByName(String name)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        var authors = new ArrayList<Author>();

        m_jdbcTemplate.query(FIND_BY_NAME_SQL, map, (ResultSet rs) -> fillAuthor(rs, authors));

        return authors;
    }

    @Override
    public Iterable<Author> findByMonthBetween(int min, int max)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("min", min);
        map.put("max", max);
        var authors = new ArrayList<Author>();

        m_jdbcTemplate.query(FIND_BY_MONTH_BETWEEN, map, (ResultSet rs) -> fillAuthor(rs, authors));

        return authors;
    }

    @Override
    public Iterable<Author> findByYearBetween(int min, int max)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("min", min);
        map.put("max", max);
        var authors = new ArrayList<Author>();

        m_jdbcTemplate.query(FIND_BY_YEAR_BETWEEN, map, (ResultSet rs) -> fillAuthor(rs, authors));

        return authors;
    }


    /////////////////////////////////////////////////////////////////////////


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
    public void deleteById(String email)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(String email)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Author> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Author> findAllById(Iterable<String> emails)
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
