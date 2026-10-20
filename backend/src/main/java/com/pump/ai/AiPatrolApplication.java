package com.pump.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AiPatrolApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiPatrolApplication.class, args);
    }
}
