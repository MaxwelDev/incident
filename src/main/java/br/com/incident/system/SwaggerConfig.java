package br.com.incident.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_REST_SERVICES_PACKAGE = "br.com.incident";
    private static final String API_NAME = "INCIDENT";
    private static final String API_DESCRIPTION = "API for get incident";
    private static final String API_VERSION = "v1";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(API_REST_SERVICES_PACKAGE))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(API_NAME, API_DESCRIPTION, API_VERSION, null,
                new Contact("Maxwel Lidogério", "", "maxwel.silva2@fatec.sp.gov.br"),
                "", "", new ArrayList());
    }

}
