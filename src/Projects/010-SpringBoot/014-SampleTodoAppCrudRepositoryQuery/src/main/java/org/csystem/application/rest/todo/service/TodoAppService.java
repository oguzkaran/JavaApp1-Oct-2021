package org.csystem.application.rest.todo.service;

import org.csystem.application.rest.todo.data.dal.TodoAppHelper;
import org.csystem.application.rest.todo.dto.TodoInfoDTO;
import org.csystem.application.rest.todo.dto.TodoSaveDTO;
import org.csystem.application.rest.todo.mapper.ITodoInfoMapper;
import org.csystem.application.rest.todo.mapper.ITodoSaveMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.csystem.util.data.DatabaseUtil.doWorkForService;

@Service
public class TodoAppService {
    private final TodoAppHelper m_todoAppHelper;
    private final ITodoInfoMapper m_todoInfoMapper;
    private final ITodoSaveMapper m_todoSaveMapper;

    //Bu metot library'ye eklenecek
    private static <T, R> List<R> convertToList(Iterable<? extends T> iterable, boolean parallel, Function<? super T, ? extends R> function)
    {
        return StreamSupport.stream(iterable.spliterator(), parallel)
                .map(function)
                .collect(Collectors.toList());
    }

    private TodoInfoDTO saveTodoCallback(TodoSaveDTO todoSaveDTO)
    {
        return m_todoInfoMapper.toTodoInfoDTO(m_todoAppHelper.saveTodo(m_todoSaveMapper.toTodo(todoSaveDTO)));
    }

    private List<TodoInfoDTO> findAllTodosCallback()
    {
        return convertToList(m_todoAppHelper.findAllTodos(), true, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByCompletedCallback(boolean completed)
    {
        return convertToList(m_todoAppHelper.findTodosByCompleted(completed), true, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleCallback(String title)
    {
        return convertToList(m_todoAppHelper.findTodosByTitle(title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByTitleContainsCallback(String text)
    {
        return convertToList(m_todoAppHelper.findTodosByTitleContains(text), false, m_todoInfoMapper::toTodoInfoDTO);
    }


    private Iterable<TodoInfoDTO> findTodosByCompletedAndTitleCallback(boolean completed, String title)
    {
        return convertToList(m_todoAppHelper.findTodosByCompletedAndTitle(completed, title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    private Iterable<TodoInfoDTO> findTodosByCompletedAndTitleContainsCallback(boolean completed, String title)
    {
        return convertToList(m_todoAppHelper.findTodosByCompletedAndTitleContains(completed, title), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    private List<TodoInfoDTO> findTodosByMonthCallback(int month)
    {
        return convertToList(m_todoAppHelper.findTodosByMonth(month), false, m_todoInfoMapper::toTodoInfoDTO);
    }

    public TodoAppService(TodoAppHelper todoAppHelper, ITodoInfoMapper todoInfoMapper, ITodoSaveMapper todoSaveMapper)
    {
        m_todoAppHelper = todoAppHelper;
        m_todoInfoMapper = todoInfoMapper;
        m_todoSaveMapper = todoSaveMapper;
    }

    public List<TodoInfoDTO> findAllTodos()
    {
        return doWorkForService(this::findAllTodosCallback, "TodoService.findAll");
    }
    public List<TodoInfoDTO> findTodosByCompleted(boolean completed)
    {
        return doWorkForService(() -> findTodosByCompletedCallback(completed), "TodoService.findTodosByCompleted");
    }

    public Iterable<TodoInfoDTO> findTodosByTitle(String title)
    {
        return doWorkForService(() -> findTodosByTitleCallback(title), "TodoService.findTodosByTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByTitleContains(String text)
    {
        return doWorkForService(() -> findTodosByTitleContainsCallback(text), "TodoService.findTodosByTitleContains");
    }

    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForService(() -> findTodosByCompletedAndTitleCallback(completed, title), "TodoService.findByCompletedAndTitle");
    }

    public Iterable<TodoInfoDTO> findTodosByCompletedAndTitleContains(boolean completed, String text)
    {
        return doWorkForService(() -> findTodosByCompletedAndTitleContainsCallback(completed, text), "TodoService.findByCompletedAndTitle");
    }

    public List<TodoInfoDTO> findTodosByMonth(int month)
    {
        return doWorkForService(() -> findTodosByMonthCallback(month), "TodoService.findTodosByMonth");
    }

    public TodoInfoDTO saveTodo(TodoSaveDTO todoSaveDTO)
    {
        return doWorkForService(() -> saveTodoCallback(todoSaveDTO), "TodoService.saveTodo");
    }
}
