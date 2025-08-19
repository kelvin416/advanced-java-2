/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanscopes.prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        PhoneBean phoneBean1 = ctx.getBean(PhoneBean.class);
        System.out.println("Phone 1 IMEI: " + phoneBean1.hashCode());

        PhoneBean phoneBean2 = ctx.getBean(PhoneBean.class);
        System.out.println("Phone 2 IMEI: " + phoneBean2.hashCode());

        ctx.close();
    }
}
