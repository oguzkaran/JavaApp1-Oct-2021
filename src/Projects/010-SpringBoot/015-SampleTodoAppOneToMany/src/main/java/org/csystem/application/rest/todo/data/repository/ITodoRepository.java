package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByCompleted(boolean completed);
    Iterable<Todo> findByTitle(String title);
    Iterable<Todo> findByTitleContains(String text);
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);
    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String text);

    @Query(value = "select * from todos where date_part('month', insert_date_time)=?", nativeQuery = true)
    Iterable<Todo> findByMonth(int month);
}
