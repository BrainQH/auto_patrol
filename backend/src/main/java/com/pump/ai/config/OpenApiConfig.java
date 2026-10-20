package com.pump.ai.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI patrolOpenApi() {
        return new OpenAPI().info(new Info()
                .title("泵站AI智能巡检系统API")
                .version("v1")
                .description("支持巡检、安防联动、设备控制、预测预警"));
    }
}
