package com.platzi.springfundamentals;

import com.platzi.springfundamentals.bean.BeanPropertiesExample;
import com.platzi.springfundamentals.bean.BeanWithDependency;
import com.platzi.springfundamentals.bean.MyBean;
import com.platzi.springfundamentals.component.ComponentDependency;
import com.platzi.springfundamentals.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class SpringFundamentalsApplication implements CommandLineRunner {

    //@Autowired //not necesary on new versions of spring boot
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private BeanWithDependency beanWithDependency;
    private BeanPropertiesExample beanPropertiesExample;
    private User user;

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.greeting();
        myBean.print();
        beanWithDependency.printWithDependency();
        System.out.println(beanPropertiesExample.propertiesExampleName());
        System.out.println(user.getEmail());
        System.out.println(user.getPass());
    }
}
