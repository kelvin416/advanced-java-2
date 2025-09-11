package com.codingnomads.springweb.resttemplate.PATCH.models;

import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private String first_name;
    private String last_name;
}
