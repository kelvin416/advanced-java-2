package com.codingnomads.springweb.resttemplate.PATCH.models;

import lombok.Data;

@Data
public class UserObject {
    User data;
    Error error;
    String status;
}
