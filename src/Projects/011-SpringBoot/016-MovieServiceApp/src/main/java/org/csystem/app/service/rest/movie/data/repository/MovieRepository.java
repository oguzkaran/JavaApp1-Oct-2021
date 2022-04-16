package org.csystem.app.service.rest.movie.data.repository;


import org.csystem.app.service.rest.movie.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository implements IMovieRepository {
    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH_SQL = "select * from movies where date_part('month', scene_date) = :month";

    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    private static void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException
    {
        do {
            var id = rs.getLong(1);
            var name = rs.getString(2);
            var sceneDate = rs.getDate(3).toLocalDate();
            var rating = rs.getLong(4);
            var cost = BigDecimal.valueOf(rs.getDouble(5));
            var imdb = rs.getDouble(6);
            movies.add(new Movie(id, name, sceneDate, rating, cost, imdb));

        } while (rs.next());
    }

    public MovieRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_jdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Iterable<Movie> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();

        paramMap.put("month", month);
        var movies = new ArrayList<Movie>();

        m_jdbcTemplate.query(FIND_BY_MONTH_SQL, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByYear(int year)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findByMonthAndYear(int month, int year)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findByYearBetween(int min, int max)
    {
        throw new UnsupportedOperationException();
    }



    /////////////////////////////////////////

    @Override
    public void delete(Movie movie)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> movies)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Movie> Iterable<S> save(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
