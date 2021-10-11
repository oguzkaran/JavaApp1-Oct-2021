package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITodoRepository extends CrudRepository<Todo, Long> {
    @Query("select td from Todo td where td.m_completed = :completed")
    Iterable<Todo> findByCompleted(boolean completed);

    @Query("select td from Todo td where td.m_title = :title")
    Iterable<Todo> findByTitle(String title);

    @Query("select td from Todo td where td.m_title like %:text%")
    Iterable<Todo> findByTitleContains(String text);

    @Query("select td from Todo td where td.m_completed=:completed and td.m_title = :title")
    Iterable<Todo> findByCompletedAndTitle(boolean completed, String title);

    @Query("select td from Todo td where td.m_completed=:completed and td.m_title like %:text%")
    Iterable<Todo> findByCompletedAndTitleContains(boolean completed, String text);

    @Query(value = "select * from todos where date_part('month', insert_date_time)=?", nativeQuery = true)
    Iterable<Todo> findByMonth(int month);
}
