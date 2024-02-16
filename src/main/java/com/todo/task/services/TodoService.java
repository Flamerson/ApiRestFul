package com.todo.task.services;

import com.todo.task.controllers.TodoController;
import com.todo.task.entities.Todo;
import com.todo.task.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Optional<Todo> listById(UUID id){
        return todoRepository.findById(id);
    }

    public List<Todo> list(){
        List<Todo> todo = todoRepository.findAll();
        if(!todo.isEmpty()){
            for(Todo todo0 : todo ){
                UUID id = todo0.getId();
                todo0.add(linkTo(methodOn(TodoController.class).listById(id)).withSelfRel().withType("GET"));
            }
        }
        return todo;
    }

    public void delete(Todo todo){
        todoRepository.delete(todo);
    }

    public Todo addLinkAll(Todo todo){
        return todo.add(linkTo(methodOn(TodoController.class).listAllTodos()).withRel("Todos").withType("GET"));
    }


}
