/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PATCH;

import com.codingnomads.springweb.resttemplate.PATCH.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PATCH.models.Task;
import java.util.Objects;

import com.codingnomads.springweb.resttemplate.PATCH.models.User;
import com.codingnomads.springweb.resttemplate.PATCH.models.UserObject;
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
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // create an empty Task
            Task task = new Task();

            // be sure to use a valid task id
//            task.setId(14134);
//
//            // set fields you want to change. All other fields are null and will not be updated
//            task.setName("use patchForObject()");
//            task.setDescription("this task was updated using patchForObject()");
//
//            // send the PATCH request using the URL, the Task created above and the ResponseObject Class
//            ResponseObject objectResponse = restTemplate.patchForObject(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), task, ResponseObject.class);
//
//            System.out.println(Objects.requireNonNull(objectResponse));
//
//            task.setName("PATCH using exchange()");
//            task.setDescription("This task was updated using PATCH");
//
//            HttpEntity<Task> httpEntity = new HttpEntity<>(task);
//            ResponseEntity<ResponseObject> response = restTemplate.exchange(
//                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(),
//                    HttpMethod.PATCH,
//                    httpEntity,
//                    ResponseObject.class);
//
//            System.out.println(Objects.requireNonNull(response));

            // creating an empty user
            User user = new User();
            User user2 = new User();

            user.setId(15184);
            user2.setId(15185);

            user.setFirst_name("Johnny");
            user.setLast_name("Walker");

            UserObject userObject = restTemplate.patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(), user, UserObject.class);
            System.out.println(Objects.requireNonNull(userObject));

            user2.setFirst_name("Miley");
            user2.setLast_name("Cirus");

            HttpEntity<User> httpUserEntity = new HttpEntity<>(user2);
            ResponseEntity<UserObject> userResponse = restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + user2.getId(),
                    HttpMethod.PATCH,
                    httpUserEntity,
                    UserObject.class);
        };
    }
}
