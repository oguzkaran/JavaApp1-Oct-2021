package org.csystem.app.service.rest.movie.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    public long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, name = "scene_date")
    public LocalDate sceneDate;

    @Column(nullable = false)
    public long rating;

    @Column(nullable = false)
    public BigDecimal cost;

    @Column(nullable = false)
    public double imdb;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY)
    public Set<Director> directors;

    public Movie()
    {

    }

    public Movie(long id, String name, LocalDate sceneDate, long rating, BigDecimal cost, double imdb)
    {
        this.id = id;
        this.name = name;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }
}
