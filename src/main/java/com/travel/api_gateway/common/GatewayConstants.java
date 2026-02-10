package com.travel.api_gateway.common;

/**
 * Centralized constants for the API gateway.
 * Prevents magic numbers, hardcoded strings, and duplicated values.
 */

public final class GatewayConstants {
    private GatewayConstants() {}

    //     Service names for routing / logging
    public static final String AUTH_SERVICE = "auth-service";
    public static final String USER_SERVICE = "user-service";

    // Route timeouts (milliseconds)
    public static final int ROUTE_TIMEOUT_MS = 5000;

    // Error messages
    public static final String UNAUTHORIZED_MSG = "Unauthorized access";
    public static final String RATE_LIMIT_EXCEEDED_MSG = "Rate limit exceeded";

    // Logging & Tracing
    public static final String X_REQUEST_ID = "X-Request-ID";
    public static final String LOG_PREFIX = "[API-GATEWAY] ";

    // JWT constants
    public static final String JWT_ROLE_CLAIM = "role";
    public static final String JWT_USER_ID_CLAIM = "userId";
}
