package com.cyexm.cyzhit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.cyexm.cyzhit.Mapper")
@SpringBootApplication
public class CyzhitApplication {
    public static void main(String[] args) {
        SpringApplication.run(CyzhitApplication.class, args);
    }
}
