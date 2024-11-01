package com.supervisor.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthFilter implements GatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
