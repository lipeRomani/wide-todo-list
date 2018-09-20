package com.wspot.todo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wspot.todo.entities.serializers.CategorySerializer;
import com.wspot.todo.entities.serializers.DateTimeSerializer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(name = "title", unique = true, nullable = false)
    @NotNull
    @Size(min = 2, message = "Titulo deve possuir ao menos 2 caracteres")
    private String title;

    @Column(name = "description", nullable = false)
    @NotNull
    @Size(min = 5, message = "Descrição deve possuir ao menos 5 caracteres")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonSerialize(using = CategorySerializer.class)
    private Category category;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonSerialize(using = DateTimeSerializer.class)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonSerialize(using = DateTimeSerializer.class)
    private LocalDateTime updatedAt;

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Task setCategory(Category category) {
        this.category = category;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Task setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Task setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
