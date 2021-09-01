package com.cuongnghiem.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5webappApplication {

    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(Spring5webappApplication.class, args);
    }

}
