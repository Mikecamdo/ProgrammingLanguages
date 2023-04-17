package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome to CS 3342!";
    }
}