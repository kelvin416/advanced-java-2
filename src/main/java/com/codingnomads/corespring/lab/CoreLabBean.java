package com.codingnomads.corespring.lab;

import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
@ToString
public class CoreLabBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean has been destroyed");
    }
}
