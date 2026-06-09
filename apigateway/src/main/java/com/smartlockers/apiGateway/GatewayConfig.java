package com.smartlockers.apiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            // 1. delivery-manager
            .route("delivery-manager", r -> r
                    .path("/api/v1/delivery/**")
                    .uri("http://localhost:8082"))

            // 2. locker-manager-locker
            .route("locker-manager-locker", r -> r
                    .path("/locker/**")
                    .uri("http://localhost:8080"))

            // 3. log-manager
            .route("log-manager", r -> r
                    .path("/api/v1/log/**")
                    .uri("http://localhost:8083"))

            // 4. residents-manager
            .route("residents-manager", r -> r
                    .path("/resident/**")
                    .uri("http://localhost:8081"))

            // 5. locker-embedded-system-open (Combines Path and Method predicates)
            .route("locker-embedded-system-open", r -> r
                    .path("/lockerShelf/{lockerShelfId}/open")
                    .and()
                    .method(HttpMethod.POST)
                    .uri("http://localhost:8084"))

            // 6. locker-manager-shelf
            .route("locker-manager-shelf", r -> r
                    .path("/lockerShelf/**")
                    .uri("http://localhost:8080"))

            .build();
    }
}