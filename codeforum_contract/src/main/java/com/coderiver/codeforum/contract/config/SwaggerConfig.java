package com.coderiver.codeforum.contract.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
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
 * Created by Shiyu Rao on 09/03/2019.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:9112")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coderiver.codeforum.contract.controller"))
                .paths(paths())
                .build();
    }

    /**
     *  Here is the describe of our swagger2 api page
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Coderiver Codeforum Rest APIs")
                .description("This page lists all rest apis for Codeforum App.")
                .version("1.0-SNAPSHOT")
                .build();
    }

    private Predicate<String> paths(){
        return Predicates.and(
                PathSelectors.regex("/*.*"),
                Predicates.not(PathSelectors.regex("/error.*"))
        );
    }

}
