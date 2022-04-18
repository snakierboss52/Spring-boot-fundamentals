package com.platzi.springfundamentals.bean;

public class BeanSecondImpl implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola desde mi implementación desde el bean 2");
    }
}
