package com.platzi.springfundamentals.bean;

public class BeanImpl implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementación desde el bean");
    }
}
