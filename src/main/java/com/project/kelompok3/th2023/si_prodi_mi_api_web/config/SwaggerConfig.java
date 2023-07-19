package com.project.kelompok3.th2023.si_prodi_mi_api_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.kelompok3.th2023.si_prodi_mi_api_web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "API Swagger SI Prodi MI",
                "Kumpulan API Swagger SI Prodi MI. Kelompok 3, MI 2A (2023)",
                "1.0",
                "Terms of Service",
                "Kelompok 3 MI 2A (2023)",
                "Apache License Version 2.0",
                "https://www.apache.org/license.html"
        );

        return apiInfo;
    }
}
