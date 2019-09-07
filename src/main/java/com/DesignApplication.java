package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
//@EnableEurekaClient//服务注解
public class DesignApplication {

    public static void main(String [] args) {
        new SpringApplicationBuilder(DesignApplication.class).run(args);
    }

}
