package com.codingnomads.corespring.examples.profileannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "deploy")
public class ServerOutlet {

    public ServerOutlet(){
        System.out.println("The server is ready for deployment....");
    }
}
