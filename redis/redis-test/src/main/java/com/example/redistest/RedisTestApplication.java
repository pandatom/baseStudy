package com.example.redistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedisTestApplication {

    public static void main(String[] args) {
//        SpringApplication.run(RedisTestApplication.class, args);
        ConfigurableApplicationContext application = SpringApplication.run(RedisTestApplication.class, args);

    }

}
