package com.wspot.todo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnore
    private Set<Task> tasks;

    public Category() {
        super();
        tasks = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public Category setTitle(String title) {
        this.title = title;
        return this;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Category addTask(Task task) {
        task.setCategory(this);
        tasks.add(task);
        return this;
    }
}
