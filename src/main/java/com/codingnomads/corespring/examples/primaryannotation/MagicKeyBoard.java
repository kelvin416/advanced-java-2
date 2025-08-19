package com.codingnomads.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MagicKeyBoard implements KeyBoard{

    public void printName(){
        System.out.println("Magic KeyBoard Used.");
    }
}
