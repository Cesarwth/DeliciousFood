package com.deliciousfood.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI deliciousFoodOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DeliciousFood API")
                        .description("API para el sistema de pedidos y entregas de DeliciousFood")
                        .version("1.0.0"));
    }
}
