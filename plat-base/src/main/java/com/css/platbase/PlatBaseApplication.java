package com.css.platbase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.css.platbase.moudles.*.mapper")
public class PlatBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatBaseApplication.class, args);
    }

}
