package com.platzi.springfundamentals.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ComponentSecondImplementation implements ComponentDependency{


    @Override
    public void greeting() {
        System.out.println("Hola mundo desde mi segundo componente");
    }
}
