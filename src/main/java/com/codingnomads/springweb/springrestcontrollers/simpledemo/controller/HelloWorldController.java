/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/courses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getLanguages(){
        return List.of("Java", "JavaScript", "GoLang", "Python");
    }

    @RequestMapping(value = "/transport/{transport}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String modeOfTransport(@PathVariable(name = "transport") String transport){
        return "I arrived using " + transport + " as my means of transportation.";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getTask(){
        return new User(2, "Kelvin", "kel@gmail.com");
    }
}
