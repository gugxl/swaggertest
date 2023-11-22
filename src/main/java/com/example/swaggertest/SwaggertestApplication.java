package com.example.swaggertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gugu"})
@EnableSwagger2
public class SwaggertestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggertestApplication.class, args);
    }

}
