package com.platzi.springfundamentals.configuration;

import com.platzi.springfundamentals.bean.BeanPropertiesExample;
import com.platzi.springfundamentals.bean.BeanPropertiesExampleImpl;
import com.platzi.springfundamentals.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({User.class})
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Bean
    public BeanPropertiesExample propertiesExample(){
        return new BeanPropertiesExampleImpl(name);
    }
}
