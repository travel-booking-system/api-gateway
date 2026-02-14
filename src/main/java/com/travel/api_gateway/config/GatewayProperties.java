package com.travel.api_gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "services")
public record GatewayProperties(
        RouteDetail auth,
        RouteDetail user
) {
    public record RouteDetail(String uri, String path, int strip) {}
}
