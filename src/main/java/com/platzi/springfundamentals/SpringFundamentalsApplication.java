package com.platzi.springfundamentals;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@AllArgsConstructor
@SpringBootApplication
public class SpringFundamentalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

}
