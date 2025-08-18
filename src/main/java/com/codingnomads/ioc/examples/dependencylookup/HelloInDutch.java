package com.codingnomads.ioc.examples.dependencylookup;

public class HelloInDutch implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "Hallo hoe is het?";
    }
}
