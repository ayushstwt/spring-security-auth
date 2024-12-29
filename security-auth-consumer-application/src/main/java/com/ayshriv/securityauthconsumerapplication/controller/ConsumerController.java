package com.ayshriv.securityauthconsumerapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/public")
    public String publicApi() {
        String url="http://localhost:8080";
        return restTemplate.getForObject(url,String.class);
    }

//    @GetMapping("/authenticated")
//    public String authenticatedApi() {
//        String url="http://localhost:8080";
//
//        return ;
//    }

}
