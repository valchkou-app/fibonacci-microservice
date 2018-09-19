package com.valchkou.cloud.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    protected String title;
    
    @Value("${spring.application.description}")
    protected String description;
    
    private static final String INCLUDE = "api";

    @Bean
    public Docket v1Api() {
        ApiInfo info = buildApiInfo("1.0");

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(true)
                .groupName(INCLUDE)
                .apiInfo(info)
                .select()
                .paths(regex(".*/"+INCLUDE+".*"))
                .build();
    }


    private ApiInfo buildApiInfo(String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }
}