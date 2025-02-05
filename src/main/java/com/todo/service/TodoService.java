/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todo.service;

import com.todo.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author VICTUS
 */
@Transactional // the transactional annotation turns this TodoService class into a service
public class TodoService {

    //interacts directly with the database using the EntityManager (instead of JpaRepository like in Spring Boot).
    //The @PersistenceContext annotation injects the EntityManager, which provides CRUD methods.
    @PersistenceContext
    EntityManager entityManager;

    public Todo CreateTodo(Todo todo) {
        //persisting into DB.
        entityManager.persist(todo);
        return todo;
    }

    public Todo UpdateTodo(Todo todo) {
        entityManager.merge(todo);
        return todo;
    }

    public Todo findToDoById(Long id) {
        return entityManager.find(Todo.class, id);
    }

    public List<Todo> GetTodos() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }

    public boolean DeleteTodo(Long id) {
        Todo todo = entityManager.find(Todo.class, id); // find the specific todo
        if (todo != null) {
            entityManager.remove(todo); // delete or remove the todo
            return true;
        }
        return false;
    }

}
