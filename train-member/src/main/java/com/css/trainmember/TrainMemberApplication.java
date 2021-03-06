package com.css.trainmember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Feign支持
public class TrainMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainMemberApplication.class, args);
    }

}
