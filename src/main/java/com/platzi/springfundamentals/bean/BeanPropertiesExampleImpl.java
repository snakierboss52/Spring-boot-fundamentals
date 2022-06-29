package com.platzi.springfundamentals.bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanPropertiesExampleImpl implements BeanPropertiesExample {

    private String name;

    public BeanPropertiesExampleImpl(String name) {
        this.name = name;
    }

    @Override
    public String propertiesExampleName() {
        log.info("Going to implementation of properties Example");
        return name;
    }
}
