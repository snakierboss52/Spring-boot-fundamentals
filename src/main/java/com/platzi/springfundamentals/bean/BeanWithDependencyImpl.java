package com.platzi.springfundamentals.bean;

public class BeanWithDependencyImpl implements BeanWithDependency {

    private Operation operation;

    public BeanWithDependencyImpl(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void printWithDependency() {
        System.out.println("Esto es una implementación del bean con dependencia y el numero de la suma de la dependencia es " + operation.sum(24));
    }
}
