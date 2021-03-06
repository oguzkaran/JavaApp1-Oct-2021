package org.csystem.app.service.rest.movie.data.repository;

import org.csystem.app.service.rest.movie.data.entity.Director;
import org.csystem.app.service.rest.movie.data.entity.DirectorDetail;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class DirectorRepositoryJDBC implements IDirectorRepositoryJDBC {
    //Bu sorgunun fonksiyon veya view yapılması daha iyi bir tekniktir. Durumu göstermek için fonksiyon yapılmamıştır
    private static final String FIND_DIRECTORS_VIA_FULL_NAME = """
            select
                case
                    when middle_name isnull then first_name || ' '  || family_name
                    else first_name || ' ' || middle_name || ' ' || family_name
                end as fullname,
                birth_date
            from directors
            """;

    private static final String FIND_BY_MOVIE_ID = "select * from get_directors_by_movie_id(:movie_id)";

    private static void fillDirectorDetail(ResultSet rs, List<DirectorDetail> directors) throws SQLException
    {
        do {
            var fullName = rs.getString(1);
            var birthDate = rs.getDate(2).toLocalDate();

            directors.add(new DirectorDetail(fullName, birthDate));
        } while (rs.next());
    }

    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    public DirectorRepositoryJDBC(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<DirectorDetail> findAllDetail()
    {
        var directors = new ArrayList<DirectorDetail>();

        m_jdbcTemplate.query(FIND_DIRECTORS_VIA_FULL_NAME, (ResultSet rs) -> fillDirectorDetail(rs, directors));

        return directors;
    }

    @Override
    public Iterable<DirectorDetail> findDetailByMovieId(long movieId)
    {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("movie_id", movieId);
        var directors = new ArrayList<DirectorDetail>();

        m_jdbcTemplate.query(FIND_BY_MOVIE_ID, paramMap, (ResultSet rs) -> fillDirectorDetail(rs, directors));

        return directors;
    }

    //////////////////////////

    @Override
    public long count()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Director director)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Director> directors)
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
    public Iterable<Director> findAll()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> longs)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Director> findById(Long aLong)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Director> S save(S entity)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Director> Iterable<S> save(Iterable<S> entities)
    {
        throw new UnsupportedOperationException();
    }
}
