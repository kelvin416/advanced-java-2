package com.codingnomads.corespring.lab;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@ComponentScan
@Configuration
@ImportResource({"classpath*:xml-config/java_dev.xml"})
public class NewJavaDevConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Car car(){
        return new Car("Mazda", "Diesel");
    }

}
