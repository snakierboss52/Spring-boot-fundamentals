package com.platzi.springfundamentals.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImpl implements ComponentDependency{


    @Override
    public void greeting() {
        System.out.println("Hola mundo desde mi componente");
    }
}
