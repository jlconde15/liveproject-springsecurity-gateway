/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jose
 */

@Configuration
public class GatewayConfig {

    @Value("${url}")
    private String businessLogicServerURL;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/metric/**")
                        .uri(businessLogicServerURL + "/metric"))
                .route(p -> p
                        .path("/profile/**")
                        .uri(businessLogicServerURL + "/profile"))
                .route(p -> p
                        .path("/advice/**")
                        .uri(businessLogicServerURL + "/advice"))
                .build();
    }

}
