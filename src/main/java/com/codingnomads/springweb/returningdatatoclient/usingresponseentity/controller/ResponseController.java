/* CodingNomads (C)2024 */
package com.codingnomads.springweb.returningdatatoclient.usingresponseentity.controller;

import com.codingnomads.springweb.returningdatatoclient.usingresponseentity.model.Task;
import com.codingnomads.springweb.returningdatatoclient.usingresponseentity.model.User;
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    User user = new User(1, "Test User", "test@email.com");
    Task task = new Task(2, 30, "GoLang", false);
    Task task2 = new Task(3, 30, "Java", true);

    @GetMapping("/constructor")
    public ResponseEntity<User> constructorMethod() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("TEST", "TEST HEADER");
        headers.add("Location", "/users/" + user.getId());
        return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }

    @GetMapping("/builder")
    public ResponseEntity<User> builderMethod() {
        return ResponseEntity.created(URI.create("/users/" + user.getId()))
                .header("TEST", "TEST HEADER")
                .body(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        if (user.getId() == id) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tasks/constructor")
    public ResponseEntity<Task> constructorTask() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("TEST", "TEST HEADER");
        headers.add("URL", "/tasks/" + task.getId());
        return new ResponseEntity<>(task, headers, HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping("/tasks/builder")
    public ResponseEntity<Task> buildTask(){
        return ResponseEntity.created(URI.create("/tasks/" + task2.getId()))
                .header("TEST", "TEST HEADER")
                .body(task2);
    }

    //getting a task id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id){
        if (task.getId() == id){
            System.out.println(task.toString());
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else if (task2.getId() == id) {
            System.out.println(task2.toString());
            return new ResponseEntity<>(task2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(task, HttpStatus.NOT_FOUND);
        }
    }
}
