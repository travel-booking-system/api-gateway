package com.travel.api_gateway.common;

/**
 * Standard HTTP headers used across the API Gateway.
 * Ensures consistency and prevents typos in filters and configs.
 */
public final class HeaderNames {
    private HeaderNames() {}

    public static final String AUTHORIZATION = "Authorization";
    public static final String CORRELATION_ID = "X-Correlation-ID";
    public static final String CLIENT_ID = "X-Client-ID";
    public static final String REQUEST_START_TIME = "X-Request-Start-Time";

    // Content negotiation
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
}
