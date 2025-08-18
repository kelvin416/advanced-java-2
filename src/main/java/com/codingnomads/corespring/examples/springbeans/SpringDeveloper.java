/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Identification identification;

    public SpringDeveloper(Address address, Identification identification) {
        this.address = address;
        this.identification = identification;
    }
}
