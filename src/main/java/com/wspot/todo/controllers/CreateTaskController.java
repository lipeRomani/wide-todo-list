package com.wspot.todo.controllers;

import com.wspot.todo.entities.Category;
import com.wspot.todo.entities.Task;
import com.wspot.todo.services.task.CreateTaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreateTaskController {

    private CreateTaskService createTaskService;

    public CreateTaskController(CreateTaskService createTaskService) {
        this.createTaskService = createTaskService;
    }

    @PostMapping(value = "/task/{category}")
    public Task create(@RequestBody @Valid Task task, @PathVariable Category category) {
        return createTaskService.create(task, category);
    }
}
