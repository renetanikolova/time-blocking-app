package com.optimizer.timeblockingapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.host}")
    private String swaggerHost;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.optimizer.timeblockingapp"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .host(swaggerHost);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Time Blocking App Backend",
                "REST APIs for Time Blocking App",
                "0.0.1-SNAPSHOT",
                null,
                null,
                null,
                null,
                Collections.emptyList());
    }

}
