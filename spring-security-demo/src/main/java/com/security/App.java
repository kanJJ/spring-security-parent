package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
@EnableSwagger2
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping(value="/hello")
    public String hello() {
        return "Hello World!";
    }
}
