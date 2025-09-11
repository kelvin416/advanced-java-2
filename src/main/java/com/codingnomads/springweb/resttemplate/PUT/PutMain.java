/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PUT;

import com.codingnomads.springweb.resttemplate.PUT.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PUT.models.Task;
import com.codingnomads.springweb.resttemplate.PUT.models.User;
import com.codingnomads.springweb.resttemplate.PUT.models.UserResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // use a valid task id
            int taskId = 14134;
            int userId = 15181;

            // request Task 5 from server
            ResponseObject responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);

            UserResponseObject userResponseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class
            );

            // confirm data was retrieved & avoid NullPointerExceptions
            Task taskToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The task with ID " + taskId + " could not be found");
            } else {
                taskToUpdate = responseObject.getData();
            }

            // update the task information
            taskToUpdate.setName("updated using put() - video demo ");
            taskToUpdate.setDescription("this task was updated using RestTemplate's put() method - video demo");
            taskToUpdate.setCompleted(false);

            // use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(), taskToUpdate);
            // get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);
            System.out.println(responseObject.toString());

            taskToUpdate.setName("updated using exchange() PUT - video demo 2");
            taskToUpdate.setDescription("this task was updated using RestTemplate's exchange() method - video demo 2");

            // create an HttpEntity wrapping the task to update
            HttpEntity<Task> httpEntity = new HttpEntity<>(taskToUpdate);
            // use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<ResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskToUpdate.getId(),
                    HttpMethod.PUT,
                    httpEntity,
                    ResponseObject.class);
            System.out.println(response.toString());

            User userToUpdate;
            if (userResponseObject == null){
                throw new Exception("The server did not return anything");
            } else if (userResponseObject.getData() == null) {
                throw new Exception("The user with id " + userId + " can't be found");
            } else {
                userToUpdate = userResponseObject.getData();
            }

            userToUpdate.setEmail("Bently@gmail.com");
            userToUpdate.setFirst_name("Leonardo");
            userToUpdate.setLast_name("DiCapri");

//            using put method to update the user to the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/", userToUpdate.getId(), userToUpdate);

//           confirming if the user has been updated to the server
            userResponseObject = restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/" +
                    userId, UserResponseObject.class);
            System.out.println(userResponseObject.toString());

            userToUpdate.setEmail("orphanblack@gmail.com");
            userToUpdate.setFirst_name("Black");

            HttpEntity<User> userHttpEntity = new HttpEntity<>(userToUpdate);
            ResponseEntity<UserResponseObject> userResponse = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(),
                    HttpMethod.PUT,
                    userHttpEntity,
                    UserResponseObject.class
            );

            System.out.println(userResponse);
        };
    }
}
