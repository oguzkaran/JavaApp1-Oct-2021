package org.csystem.app.service.rest.competiton.data.repository;

import org.csystem.app.service.rest.competiton.data.entity.Author;
import org.csystem.util.data.repository.ICrudRepository;

public interface IAuthorRepository extends ICrudRepository<Author, String> {
    Iterable<Author> findByName(String name);
    Iterable<Author> findByMonthBetween(int min, int max);
    Iterable<Author> findByYearBetween(int min, int max);
}
