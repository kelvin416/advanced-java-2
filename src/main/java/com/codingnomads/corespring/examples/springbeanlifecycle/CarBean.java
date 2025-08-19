package com.codingnomads.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class CarBean implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("This is a very new car inside a bean");
    }
}
