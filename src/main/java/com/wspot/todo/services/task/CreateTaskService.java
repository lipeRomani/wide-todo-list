package com.wspot.todo.services.task;

import com.wspot.todo.entities.Category;
import com.wspot.todo.entities.Task;

import javax.persistence.EntityExistsException;

public interface CreateTaskService {
    Task create(Task task, Category category) throws EntityExistsException;
}
