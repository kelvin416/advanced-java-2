/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.GET.getForEntity;

import com.codingnomads.springweb.resttemplate.GET.models.QuoteTemplate;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            ResponseEntity<QuoteTemplate[]> responseEntity =
                    restTemplate.getForEntity("https://zenquotes.io/api/random", QuoteTemplate[].class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                QuoteTemplate[] quoteTemplate = responseEntity.getBody();
                System.out.println(Arrays.toString(quoteTemplate));
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            ResponseEntity<ExcuserApi2[]> responseEntity1 =
                    restTemplate.getForEntity("https://excuser-three.vercel.app/v1/excuse", ExcuserApi2[].class);

            if (responseEntity1.getStatusCode().equals(HttpStatus.OK) && responseEntity1.getBody() != null){
                ExcuserApi2[] excuserApi2 = responseEntity1.getBody();
                System.out.println(Arrays.toString(excuserApi2));
            } else {
                System.out.println("Something wen wrong!");
            }
        };
    }
}
