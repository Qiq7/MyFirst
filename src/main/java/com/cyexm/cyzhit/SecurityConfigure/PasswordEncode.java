package com.cyexm.cyzhit.SecurityConfigure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncode {

        @Bean
        public PasswordEncoder getpwd()
        {
            return new BCryptPasswordEncoder();
        }
}
