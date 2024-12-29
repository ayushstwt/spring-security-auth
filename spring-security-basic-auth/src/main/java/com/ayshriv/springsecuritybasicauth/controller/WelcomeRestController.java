package com.ayshriv.springsecuritybasicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security Basic Authentication";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Greeting from Spring Security Basic Authentication";
    }
}
