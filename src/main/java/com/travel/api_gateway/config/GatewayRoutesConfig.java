package com.travel.api_gateway.config;

import com.travel.api_gateway.common.GatewayConstants;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    private final GatewayProperties gatewayProperties;

    public GatewayRoutesConfig(GatewayProperties gatewayProperties){
        this.gatewayProperties = gatewayProperties;
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(GatewayConstants.AUTH_SERVICE, r -> r
                        .path(gatewayProperties.auth().path())
                        .filters(f -> f
                                .stripPrefix(gatewayProperties.auth().strip()))
                        .uri(gatewayProperties.auth().uri())
                )
                .route(GatewayConstants.USER_SERVICE, r -> r
                        .path(gatewayProperties.user().path())
                        .filters(f -> f
                                .stripPrefix(gatewayProperties.user().strip())

                        )
                        .uri(gatewayProperties.user().uri())
                )
                .build();
    }
}
