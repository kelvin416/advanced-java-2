/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.DELETE;

import com.codingnomads.springweb.resttemplate.DELETE.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.DELETE.models.Task;
import com.codingnomads.springweb.resttemplate.DELETE.models.User;
import com.codingnomads.springweb.resttemplate.DELETE.models.UserObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
//            Task newTask = Task.builder()
//                    .name("should be deleted")
//                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
//                    // be sure to enter a valid user id
//                    .userId(380)
//                    .completed(false)
//                    .build();
//
//            // POST new task to server
//            ResponseObject responseObject = restTemplate.postForObject(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks/", newTask, ResponseObject.class);
//
//            // confirm data was returned & avoid NullPointerExceptions
//            if (responseObject == null) {
//                throw new Exception("The server did not return anything. Not even a ResponseObject!");
//            } else if (responseObject.getData() == null) {
//                throw new Exception("The server encountered this error while creating the task:"
//                        + responseObject.getError().getMessage());
//            } else {
//                newTask = responseObject.getData();
//            }
//
//            System.out.println("The task was successfully created");
//            System.out.println(newTask);
//
//            // delete the newTask using the ID the server returned
//            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId());
//            System.out.println("The task was also successfully deleted");
//
//            // try to GET, verify record was deleted
//            try {
//                restTemplate.getForEntity(
//                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(), ResponseObject.class);
//            } catch (HttpClientErrorException e) {
//                System.out.println(e.getMessage());
//            }
//
//            // delete using exchange()
//            HttpEntity<Task> httpEntity = new HttpEntity<>(newTask);
//            try {
//                restTemplate.exchange(
//                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(),
//                        HttpMethod.DELETE,
//                        httpEntity,
//                        ResponseObject.class);
//            } catch (HttpClientErrorException e) {
//                System.out.println(e.getMessage());
//            }

            User newUser1 = User.builder()
                    .email("gale1234@gmail.com")
                    .first_name("Gale")
                    .last_name("Dornick")
                    .build();
            User newUser2 = User.builder()
                    .email("harvey123@gmail.com")
                    .first_name("Harvey")
                    .last_name("Elliot")
                    .build();

//            post new users to server
            UserObject userObject1 = restTemplate.postForObject("http://demo.codingnomads.co:8080/tasks_api/users/", newUser1, UserObject.class);
            UserObject userObject2 = restTemplate.postForObject("http://demo.codingnomads.co:8080/tasks_api/users/", newUser2, UserObject.class);

            //confirming that the data was returned and no null pointers
            if (userObject1 == null){
                System.out.println("The server did not return anything");
            } else if (userObject1.getData() == null) {
                System.out.println("The server encountered an error while creating the new user");
            } else {
                newUser1 = userObject1.getData();
            }

            System.out.println("The user was successfully created");
            System.out.println(newUser1.toString());


            //deleting user 1 using delete() method.
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser1.getId(), UserObject.class);
            System.out.println("The user was successfully deleted");

            //Confirming if the user was deleted

            try {
                restTemplate.getForEntity("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser1.getId(), UserObject.class);
            } catch (HttpClientErrorException e){
                System.out.println(e.getMessage());
            }

            //let's create the next user
            if (userObject2 == null){
                System.out.println("The server failed to return smth");
            } else if (userObject2.getData() == null) {
                System.out.println("The server encountered an error");
            } else {
                newUser2 = userObject2.getData();
            }

            System.out.println("User 2 was success");
            System.out.println(newUser2.toString());
            //using exchange() method
            HttpEntity<User> userHttpEntity2 = new HttpEntity<>(newUser2);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser2.getId(),
                        HttpMethod.DELETE,
                        userHttpEntity2,
                        UserObject.class);
                System.out.println("Successfully deleted user 2");
            } catch (HttpClientErrorException e){
                System.out.println(e.getMessage());
            }


        };
    }
}
