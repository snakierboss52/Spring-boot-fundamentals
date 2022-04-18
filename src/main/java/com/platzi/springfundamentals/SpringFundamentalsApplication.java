package com.platzi.springfundamentals;

import com.platzi.springfundamentals.bean.BeanWithDependency;
import com.platzi.springfundamentals.bean.MyBean;
import com.platzi.springfundamentals.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFundamentalsApplication implements CommandLineRunner {

    //@Autowired //not necesary on new versions of spring boot
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private BeanWithDependency beanWithDependency;

    public SpringFundamentalsApplication(@Qualifier("componentSecondImplementation") ComponentDependency componentDependency, MyBean myBean, BeanWithDependency beanWithDependency) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.beanWithDependency = beanWithDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFundamentalsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.greeting();
        myBean.print();
        beanWithDependency.printWithDependency();
    }
}
