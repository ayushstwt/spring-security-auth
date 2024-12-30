package com.ayshriv.springsecurityregisterlogin.repository;

import com.ayshriv.springsecurityregisterlogin.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);
}
