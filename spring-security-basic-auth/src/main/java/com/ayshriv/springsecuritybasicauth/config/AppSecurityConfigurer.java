package com.ayshriv.springsecuritybasicauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigurer {

    // SecurityFilterChain

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                req->{
                    req.requestMatchers("/welcome","/contact-us","about-us")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                }
        ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    // InMemory user password
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails user1=User.withDefaultPasswordEncoder()
                .username("ayshriv")
                .password("ayshriv@123")
                .build();

        UserDetails user2=User.withDefaultPasswordEncoder()
                .username("ayush")
                .password("ayush@123")
                .build();

        UserDetails user3=User.withDefaultPasswordEncoder()
                .username("ayush")
                .password("ayush@123")
                .build();

        UserDetails user4=User.withDefaultPasswordEncoder()
                .username("ayush")
                .password("ayush@123")
                .build();

        return new InMemoryUserDetailsManager(user1,user2,user3,user4);
    }
}
