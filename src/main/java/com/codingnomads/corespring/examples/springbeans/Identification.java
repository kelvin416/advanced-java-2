package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Identification {

    private String name;
    private String email;

    public Identification(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
