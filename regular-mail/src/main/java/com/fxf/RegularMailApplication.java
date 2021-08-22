package com.fxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RegularMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegularMailApplication.class, args);
    }

}
