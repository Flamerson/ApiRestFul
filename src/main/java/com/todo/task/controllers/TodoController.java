package com.todo.task.controllers;

import com.todo.task.Dtos.TodoRecordDto;
import com.todo.task.entities.Todo;
import com.todo.task.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Object> saveTodos(@RequestBody @Valid TodoRecordDto todoRecordDto){
        var todo = new Todo();
        BeanUtils.copyProperties(todoRecordDto, todo);
        Todo todo0 = todoService.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.addLinkAll(todo0));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> listAllTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listById(@PathVariable(value = "id") UUID id){
        Optional<Todo> todo = todoService.listById(id);
        return todo.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK).body(todoService.addLinkAll(value))).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo Not Found!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable(value = "id")UUID id ,@RequestBody @Valid TodoRecordDto todoRecordDto){
        Optional<Todo> todo = todoService.listById(id);
        if(todo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo Not Found!");
        }
        var todo0 = new Todo();
        BeanUtils.copyProperties(todoRecordDto, todo0);
        todo0.setId(todo.get().getId());
        Todo todo1 = todoService.saveTodo(todo0);
        return ResponseEntity.status(HttpStatus.OK).body(todoService.addLinkAll(todo1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(value = "id") UUID id){
        Optional<Todo> todo = todoService.listById(id);
        if(todo.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo Not Found!");
        }
        todoService.delete(todo.get());
        return ResponseEntity.status(HttpStatus.OK).body("Todo Deleted Successfully!");
    }

}
