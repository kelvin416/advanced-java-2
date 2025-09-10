/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForObject;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import com.codingnomads.springweb.resttemplate.POST.models.User;
import com.codingnomads.springweb.resttemplate.POST.models.UserObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForObject() - video demo")
                    .description("get comfortable using the RestTemplate postForObject() method")
                    // use a valid user id
                    .userId(15135)
                    .completed(false)
                    .build();

            ResponseObject taskReturnedByServerAfterPost = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            if (taskReturnedByServerAfterPost != null) {
                System.out.println(taskReturnedByServerAfterPost.toString());
            }

            User newUser = User.builder()
                    .email("daleblond3@gmai.com")
                    .first_name("James")
                    .last_name("Cameroon")
                    .build();

            UserObject userToBeReturnedAfterPost = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users", newUser, UserObject.class);

            if (userToBeReturnedAfterPost != null){
                System.out.println(userToBeReturnedAfterPost.toString());
            }
        };
    }
}
