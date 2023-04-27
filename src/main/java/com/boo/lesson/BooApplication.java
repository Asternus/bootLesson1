package com.boo.lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "default");
        SpringApplication.run(BooApplication.class, args);
    }

}
