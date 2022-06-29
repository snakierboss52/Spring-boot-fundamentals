package com.platzi.springfundamentals;

import com.platzi.springfundamentals.bean.BeanPropertiesExample;
import com.platzi.springfundamentals.bean.BeanWithDependency;
import com.platzi.springfundamentals.bean.MyBean;
import com.platzi.springfundamentals.component.ComponentDependency;
import com.platzi.springfundamentals.entities.Users;
import com.platzi.springfundamentals.pojo.User;
import com.platzi.springfundamentals.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class SpringFundamentalsApplication {

    //@Autowired //not necesary on new versions of spring boot
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private BeanWithDependency beanWithDependency;
    private BeanPropertiesExample beanPropertiesExample;
    private User user;
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

}
