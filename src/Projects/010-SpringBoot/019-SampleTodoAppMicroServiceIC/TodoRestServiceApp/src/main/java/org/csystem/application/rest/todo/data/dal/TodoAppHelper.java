package org.csystem.application.rest.todo.data.dal;

import org.csystem.application.rest.todo.data.entity.Item;
import org.csystem.application.rest.todo.data.entity.Todo;
import org.csystem.application.rest.todo.data.repository.IItemRepository;
import org.csystem.application.rest.todo.data.repository.ITodoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

@Component
public class TodoAppHelper {
    private final ITodoRepository m_todoRepository;
    private final IItemRepository m_itemRepository;

    private Item saveItemCallback(Item item)
    {
        var todoOpt = m_todoRepository.findById(item.todoId);

        if (todoOpt.isEmpty())
            throw new IllegalArgumentException("Invalid todo id");

        item.todo = todoOpt.get();

        return m_itemRepository.save(item);
    }

    public TodoAppHelper(ITodoRepository todoRepository, IItemRepository itemRepository)
    {
        m_todoRepository = todoRepository;
        m_itemRepository = itemRepository;
    }

    public Iterable<Todo> findAllTodos()
    {
        return doWorkForRepository(m_todoRepository::findAll, "TodoAppDAL.saveTodo");
    }

    public Iterable<Todo> findTodosByCompleted(boolean completed)
    {
        return doWorkForRepository(() -> m_todoRepository.findByCompleted(completed), "TodoAppDAL.findTodosByCompleted");
    }

    public Iterable<Todo> findTodosByTitle(String title)
    {
        return doWorkForRepository(() -> m_todoRepository.findByTitle(title), "TodoAppDAL.findTodosByTitle");
    }

    public Iterable<Todo> findTodosByTitleContains(String text)
    {
        return doWorkForRepository(() -> m_todoRepository.findByTitleContains(text), "TodoAppDAL.findTodosByTitleContains");
    }

    public Iterable<Todo> findTodosByCompletedAndTitle(boolean completed, String title)
    {
        return doWorkForRepository(() -> m_todoRepository.findByCompletedAndTitle(completed, title), "TodoAppDAL.findByCompletedAndTitle");
    }

    public Iterable<Todo> findTodosByCompletedAndTitleContains(boolean completed, String text)
    {
        return doWorkForRepository(() -> m_todoRepository.findByCompletedAndTitleContains(completed, text),
                "TodoAppDAL.findByCompletedAndTitleContains");
    }

    public Iterable<Todo> findTodosByMonth(int month)
    {
        return doWorkForRepository(() -> m_todoRepository.findByMonth(month), "TodoAppDAL.findTodosByMonth");
    }

    public Todo saveTodo(Todo todo)
    {
        return doWorkForRepository(() -> m_todoRepository.save(todo), "TodoAppDAL.saveTodo");
    }

    @Transactional
    public Item saveItem(Item item)
    {
        return doWorkForRepository(() -> saveItemCallback(item), "TodoAppDAL.saveItem");
    }
}
