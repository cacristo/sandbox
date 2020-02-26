package com.exercise.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API configuration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private final BuildProperties buildProperties;

    @Autowired
    public SwaggerConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.exercise.sandbox"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sandbox API")
                .description("Exercise training.")
                .version(String.format("%s %s", buildProperties.get("build.profile").toUpperCase(), buildProperties.getVersion()))
                //.contact(new Contact("John Doe", "www.example.com", "myeaddress@company.com"))
                //.license("License of API")
                //.licenseUrl("API license URL")
                //.termsOfServiceUrl(Collections.emptyList())
                .build();
    }
}
