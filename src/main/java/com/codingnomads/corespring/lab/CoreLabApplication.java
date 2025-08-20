/* CodingNomads (C)2024 */
package com.codingnomads.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreLabApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(NewJavaDevConfig.class);
        Car car = ctx.getBean(Car.class);
        Car car2 = ctx.getBean(Car.class);
        System.out.println("This muscle car that has just arrived is from a brand" +
                "called " +car.getName()+ " which has a " + car.getFuelType() + " engine");

        System.out.println(" ------------ ");

        System.out.println(car2.getName() + " is a fresher car which has the audience dropping " +
                "their jaws because its is fueled by " + car2.getFuelType());
        System.out.println("****************");

        String[] javaDevs = ctx.getBeanNamesForType(JavaDev.class);

        for(String devs : javaDevs){
            System.out.println("The assessor is interviewing a " + ctx.getBean(devs, JavaDev.class).getLanguage()
            + " developer from the email: " + ctx.getBean(devs, JavaDev.class).getEmail() + ". His" +
                    " name is " + ctx.getBean(devs, JavaDev.class).getName());
        }

        System.out.println("Thank you for your time.");

        CoreLabBean coreLabBean = ctx.getBean(CoreLabBean.class);
        System.out.println(coreLabBean);
    }
}
