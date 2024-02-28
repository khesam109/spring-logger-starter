package com.khesam.logger.model;

public record SystemInfo(
        String name,
        String node,
        String ip,
        String applicationId
) {
}
