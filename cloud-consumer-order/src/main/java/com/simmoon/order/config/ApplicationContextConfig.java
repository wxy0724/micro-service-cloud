package com.simmoon.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    /**
     * RestTemplate提供了多种便捷访问远程Http服务的方法
     * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
     * 官方文档地址：
     * 使用restTemplate访问restful接口费将简单：
     *      url：REST请求地址
     *      requestMap：请求参数
     *      ResponseBean.class：HTTP响应转换被转换成的对象类型
     * @return
     */
    @Bean
    @LoadBalanced // 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
