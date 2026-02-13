package com.travel.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    private final ServiceUrlConfig serviceUrlConfig;

    public GatewayRoutesConfig(ServiceUrlConfig serviceUrlConfig){
        this.serviceUrlConfig = serviceUrlConfig;
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .filters(f -> f.stripPrefix(2))
                        .uri(serviceUrlConfig.auth())
                )
                .route("user-service", r -> r
                        .path("/api/users/**")
                        .filters(f -> f
                                .stripPrefix(2)

                        )
                        .uri(serviceUrlConfig.user())
                )
                .build();
    }
}
