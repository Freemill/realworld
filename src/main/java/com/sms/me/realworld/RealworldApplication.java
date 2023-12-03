package com.sms.me.realworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@EnableConfigurationProperties
@SpringBootApplication
public class RealworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealworldApplication.class, args);
    }

}
