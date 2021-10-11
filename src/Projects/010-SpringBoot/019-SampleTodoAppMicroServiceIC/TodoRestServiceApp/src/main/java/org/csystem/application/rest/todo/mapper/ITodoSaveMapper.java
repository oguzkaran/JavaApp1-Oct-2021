package org.csystem.application.rest.todo.mapper;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoSaveMapperImpl", componentModel = "spring")
public interface ITodoSaveMapper {
    Todo toTodo(TodoSaveDTO todoSaveDTO);
    TodoSaveDTO toTodoSaveDTO(Todo todo);
}
