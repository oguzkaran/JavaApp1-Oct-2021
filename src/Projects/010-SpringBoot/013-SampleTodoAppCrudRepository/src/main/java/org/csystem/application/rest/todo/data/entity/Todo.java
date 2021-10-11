package org.csystem.application.rest.todo.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    public long id;

    @Column(name = "title", length = 128, nullable = false)
    public String title;

    @Column(name = "text", length = 512)
    public String text;

    @Column(name = "insert_date_time", nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();

    @Column(name = "last_update", nullable = false)
    public LocalDateTime lastUpdate = insertDateTime;

    @Column(name = "completed", nullable = false)
    public boolean completed;
}
