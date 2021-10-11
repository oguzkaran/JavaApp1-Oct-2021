package org.csystem.application.rest.todo.data.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "items")
public class Item { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    public long id;

    public String text;

    @Column(name = "insert_date_time", nullable = false)
    public LocalDateTime insertDateTime = LocalDateTime.now();

    @Column(name = "last_update", nullable = false)
    public LocalDateTime lastUpdate = insertDateTime;

    @Column(name = "completed", nullable = false)
    public boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    public Todo todo;

    @Transient
    public long todoId;
}
