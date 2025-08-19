package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperConfiguration {

    @Bean
    public Framework framework(){
        return new Framework();
    }
}
