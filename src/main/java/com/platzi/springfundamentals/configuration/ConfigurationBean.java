package com.platzi.springfundamentals.configuration;

import com.platzi.springfundamentals.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    public MyBean beanOperationGreeting(){
        return new BeanSecondImpl();
    }

    @Bean
    public Operation beanOperationSum(){
        return new OperationImpl();
    }

    @Bean
    public BeanWithDependency operationWithDependency(Operation operation){
        return new BeanWithDependencyImpl(operation);
    }
}
