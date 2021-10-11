package org.csystem.application.rest.todo.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "todos")
public class Todo { //POJO (Plain Old Java Object)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    public long id;

    @Column(name = "title", length = 128, nullable = false)
    public String title;

    @Column(name = "description", length = 512)
    public String description;

    @Column(name = "insert_date_time", nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();

    @Column(name = "completed", nullable = false)
    public boolean completed;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Item> items;
}
