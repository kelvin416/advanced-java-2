/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.scopeannotaion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        final Car car1 = ctx.getBean(Car.class);
        final Car car2 = ctx.getBean(Car.class);

        System.out.println("------HashCode of Car Bean--------");
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());

        final Curtains curtains1 = ctx.getBean(Curtains.class);
        final Curtains curtains2 = ctx.getBean(Curtains.class);

        System.out.println("------HashCode of Curtain Bean--------");
        System.out.println(curtains1.hashCode());
        System.out.println(curtains2.hashCode());


        ctx.close();
    }
}
