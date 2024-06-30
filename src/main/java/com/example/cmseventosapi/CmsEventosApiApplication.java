package com.example.cmseventosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.cmseventosapi.repositories")
@EnableScheduling
public class CmsEventosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsEventosApiApplication.class, args);
    }

}
