package com.codingnomads.springweb.resttemplate.DELETE.models;

import com.codingnomads.springweb.resttemplate.PATCH.models.Error;
import lombok.Builder;
import lombok.Data;

@Data
public class UserObject {
    User data;
    Error error;
    String status;
}
