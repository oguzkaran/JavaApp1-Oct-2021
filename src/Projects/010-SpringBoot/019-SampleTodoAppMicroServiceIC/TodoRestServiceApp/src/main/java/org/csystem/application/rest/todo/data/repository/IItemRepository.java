package org.csystem.application.rest.todo.data.repository;

import org.csystem.application.rest.todo.data.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item, Long> {
    //...
}
