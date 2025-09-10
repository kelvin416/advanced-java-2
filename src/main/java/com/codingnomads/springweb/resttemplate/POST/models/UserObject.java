package com.codingnomads.springweb.resttemplate.POST.models;

import lombok.Data;

@Data
public class UserObject {
    User user;
    Error error;
    String status;
}
