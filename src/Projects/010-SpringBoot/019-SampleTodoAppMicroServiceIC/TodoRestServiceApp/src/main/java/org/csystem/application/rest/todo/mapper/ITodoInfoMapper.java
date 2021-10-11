package org.csystem.application.rest.todo.mapper;

import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TodoInfoMapperImpl", componentModel = "spring")
public interface ITodoInfoMapper {
    Todo toTodo(TodoInfoDTO todoInfoDTO);
    TodoInfoDTO toTodoInfoDTO(Todo todo);
}
