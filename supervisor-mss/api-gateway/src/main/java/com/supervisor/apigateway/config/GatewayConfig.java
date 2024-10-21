package com.supervisor.apigateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-ms", r -> r.path("/api/v1/identity/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://AUTH-MS"))
                .route("indicadores-ms", r -> r.path("/api/v1/indicadores/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://INDICADORES-MS"))
                .build();
    }
}
