package com.simmoon.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApplication.class, args);
    }
}
