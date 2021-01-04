package com.simmoon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomRule {

    public IRule customRule (){
        return new RandomRule();
    }


}
