package com.travel.api_gateway.common;

/**
 * Defines the execution order for API Gateway filters.
 * Lower numbers execute first in Spring Cloud Gateway.
 */
public final class FilterOrder {

    private FilterOrder() {} // Prevent instantiation

    public static final int CORRELATION_ID_FILTER = 1;
    public static final int JWT_AUTH_FILTER = 2;
    public static final int LOGGING_FILTER = 3;
    public static final int RATE_LIMIT_FILTER = 4;
}