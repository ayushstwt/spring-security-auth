package com.ayshriv.securedoauth.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

//    @GetMapping("/user")
//    public String getUser(OAuth2AuthenticationToken token) {
//        return token.getPrincipal().getAttributes().toString();
//    }

    @GetMapping("/user")
    public String getUserByGoogle(OAuth2AuthenticationToken token) {
        String registrationId = token.getAuthorizedClientRegistrationId(); // google or github
        return "Logged in with: " + registrationId + "\nUser Details: " + token.getPrincipal().getAttributes();
    }
}
