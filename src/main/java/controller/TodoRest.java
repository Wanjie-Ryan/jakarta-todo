/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.todo.entity.Todo;
import com.todo.service.TodoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author VICTUS
 */
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    //injecting an instance of the service class
    @Inject
    TodoService todoService;

    @Path("create")
    @POST
    public Response CreateTodo(Todo todo) {
        //to access this endpoint you need to go to
        // api/v1/todo/create
        todoService.CreateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response UpdateTodo(Todo todo) {
        todoService.UpdateTodo(todo);
        return Response.ok(todo).build();

    }

    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        return todoService.findToDoById(id);
    }

    @Path("allTodos")
    @GET

    public List<Todo> getTodos() {
        return todoService.GetTodos();
    }

}
