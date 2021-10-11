package org.csystem.application.rest.todo.controller;

import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.csystem.application.rest.todo.service.TodoAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {
    private final TodoAppService m_todoAppService;

    public TodoController(TodoAppService todoAppService)
    {
        m_todoAppService = todoAppService;
    }

    @GetMapping("todos/all")
    public List<TodoInfoDTO> findAllTodos()
    {
        return m_todoAppService.findAllTodos();
    }

    @GetMapping("todos/find/completed")
    public List<TodoInfoDTO> findTodosByCompleted(@RequestParam("comp") boolean completed)
    {
        return m_todoAppService.findTodosByCompleted(completed);
    }

    @GetMapping("todos/find/title")
    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return m_todoAppService.findTodosByTitle(title);
    }

    @GetMapping("todos/find/title/contains")
    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return m_todoAppService.findTodosByTitleContains(text);
    }

    @GetMapping("todos/find/title/completed")
    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitle(@RequestParam(defaultValue = "true") boolean completed, String title)
    {
        return m_todoAppService.findTodosByCompletedAndTitle(completed, title);
    }

    @GetMapping("todos/find/title/completed/contains")
    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitleContains(@RequestParam(defaultValue = "true") boolean completed, String text)
    {
        return m_todoAppService.findTodosByCompletedAndTitleContains(completed, text);
    }

    @GetMapping("todos/find/month")
    public List<TodoInfoDTO> findTodosByMonth(int month)
    {
        return m_todoAppService.findTodosByMonth(month);
    }

    @PostMapping("save")
    public TodoInfoDTO saveTodo(@RequestBody TodoSaveDTO todoSaveDTO)
    {
        return m_todoAppService.saveTodo(todoSaveDTO);
    }
}
