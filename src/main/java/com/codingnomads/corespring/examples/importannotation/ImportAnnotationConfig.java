/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DeveloperConfiguration.class)
public class ImportAnnotationConfig {
    @Bean
    public SpringDeveloper springDeveloper(){
        return new SpringDeveloper();
    }
}
