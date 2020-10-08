package com.mytool.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class FarmApplication {
    public static void main(String[] args) {
        SpringApplication.run(FarmApplication.class, args);
    }
}
