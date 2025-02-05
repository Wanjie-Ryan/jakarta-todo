/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todo.entity;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author VICTUS
 */
// transform this object into a persistable entity that you can store in your DB.
@Entity
public class Todo {

    @Id // the id should be unique (primary key)
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generate the Ids.
    private Long Id;
    @NotEmpty(message = "Task must be set") // the task field should not be empty and no null value can be inputted at the same time
    @Size(min = 5, message = "Task should be more than 5 characters")
    private String task;
    @NotNull(message = "Due Date must be set")
    @FutureOrPresent(message = "Due Date must either be in the present or the future")
    @JsonbDateFormat(value = "yyy-MM-dd")
    private LocalDate dueDate;
    private Boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;

    // transforming this method into a lifecycle callback which is invoked at a specific point in time.
    // the PrePersist invokes this method just before the entity is persisted into the DB
    @PrePersist
    private void init() {
        setDateCreated(LocalDate.now());
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

}
