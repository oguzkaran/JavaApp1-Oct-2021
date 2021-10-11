package org.csystem.application.rest.todo.controller;

import org.csystem.application.rest.todo.dto.ItemSaveDTO;
import org.csystem.application.rest.todo.service.TodoAppService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo/item")
public class ItemController {
    private final TodoAppService m_todoAppService;

    public ItemController(TodoAppService todoAppService)
    {
        m_todoAppService = todoAppService;
    }

    @PostMapping("save")
    public ItemSaveDTO saveItem(@RequestBody ItemSaveDTO itemSaveDTO)
    {
        return m_todoAppService.saveItem(itemSaveDTO);
    }
}
