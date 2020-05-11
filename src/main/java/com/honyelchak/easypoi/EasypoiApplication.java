package com.honyelchak.easypoi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.honyelchak.easypoi.dao")
public class EasypoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasypoiApplication.class, args);
    }

}
