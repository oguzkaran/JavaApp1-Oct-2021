package org.csystem.app.service.rest.movie.data.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "directors")
public class Director { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    public long id;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "family_name", nullable = false)
    public String familyName;

    @Column(name = "birth_date", nullable = false)
    public LocalDate birthDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "movies_to_director", joinColumns = @JoinColumn(name = "director_id", referencedColumnName = "director_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movie_id", nullable = false))
    public Set<Movie> movies;
}
