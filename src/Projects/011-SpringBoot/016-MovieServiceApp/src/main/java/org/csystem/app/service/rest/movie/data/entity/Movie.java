package org.csystem.app.service.rest.movie.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movie {
    public long id;
    public String name;
    public LocalDate sceneDate;
    public long rating;
    public BigDecimal cost;
    public double imdb;

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
