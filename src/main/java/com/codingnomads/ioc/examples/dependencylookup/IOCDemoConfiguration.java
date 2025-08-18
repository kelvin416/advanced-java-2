/* CodingNomads (C)2024 */
package com.codingnomads.ioc.examples.dependencylookup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IOCDemoConfiguration {

    @Bean
    public GreetingProvider provider() {
        return new CodingNomadsGreetingProvider();
    }

    @Bean
    public GreetingRenderer renderer() {
        GreetingRenderer renderer = new StandardOutGreetingRenderer();
        renderer.setGreetingProvider(provider());
        return renderer;
    }

    //    Creating a new bean for hello in dutch class
    @Bean
    public GreetingProvider provider2(){
        return new HelloInDutch();
    }

    @Bean
    public GreetingRenderer renderer2(){
        GreetingRenderer renderer = new StandardOutGreetingRenderer();
        renderer.setGreetingProvider(provider2());
        return renderer;
    }
}
