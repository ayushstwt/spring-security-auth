package com.ayshriv.springsecurityregisterlogin.controller;

import com.ayshriv.springsecurityregisterlogin.entity.Customer;
import com.ayshriv.springsecurityregisterlogin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/customer")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        String encodedPassword = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(encodedPassword);
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer Registered", HttpStatus.CREATED);
    }


}
