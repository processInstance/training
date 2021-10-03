package com.css.training.platgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlatGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatGatewayApplication.class, args);
    }

}
