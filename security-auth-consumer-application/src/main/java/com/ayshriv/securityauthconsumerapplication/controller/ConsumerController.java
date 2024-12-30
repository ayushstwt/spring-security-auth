package com.ayshriv.securityauthconsumerapplication.controller;

import com.ayshriv.securityauthconsumerapplication.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    WelcomeService welcomeService;

    @GetMapping("/auth")
    public String authApi() {
        return welcomeService.getAuthenticatedResponse();
    }

    @GetMapping("/public")
    public String publicApi() {
        return welcomeService.getNormalResponse();
    }


}
