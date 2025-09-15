package com.codingnomads.springweb.returningdatatoclient.usingresponseentity.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {

    private long id;
    private int taskHandled;
    private String language;
    private boolean complete;
}
