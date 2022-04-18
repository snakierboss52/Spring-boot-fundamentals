package com.platzi.springfundamentals.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanWithDependencyImpl implements BeanWithDependency {

    private Operation operation;

    public BeanWithDependencyImpl(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void printWithDependency() {
        log.info("Going out to the first dependency and printing the sum");
        System.out.println(operation.sum(24));
    }
}
