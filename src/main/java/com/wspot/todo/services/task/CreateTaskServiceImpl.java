package com.wspot.todo.services.task;

import com.wspot.todo.entities.Category;
import com.wspot.todo.entities.Task;
import com.wspot.todo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class CreateTaskServiceImpl implements CreateTaskService {

    private TaskRepository taskRepository;

    public CreateTaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(Task task, Category category) throws EntityExistsException {

        Optional<Task> optionalTask = taskRepository.findByTitle(task.getTitle());

        if (optionalTask.isPresent()) {
            throw new EntityExistsException("Tarefa já existe");
        }

        task.setCategory(category);
        return taskRepository.save(task);
    }
}
