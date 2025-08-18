package com.codingnomads.corespring.examples.application_context.customeventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordRegistrationEventListener implements ApplicationListener<UserRegistrationCompletedEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("-----Typing the password-------");
    }
}
