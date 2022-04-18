package com.platzi.springfundamentals.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
@Getter
@Setter
@AllArgsConstructor
public class User {

    private String email;
    private String pass;

}
