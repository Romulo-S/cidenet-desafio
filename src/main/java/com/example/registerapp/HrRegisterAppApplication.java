package com.example.registerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Register Employee  API", version = "1.0"))
public class HrRegisterAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrRegisterAppApplication.class, args);
    }

}
