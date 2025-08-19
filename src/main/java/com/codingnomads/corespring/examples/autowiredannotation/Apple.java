package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component("apple")
@ToString
public class Apple implements Screen{
}
