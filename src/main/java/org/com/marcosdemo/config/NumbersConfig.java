package org.com.marcosdemo.config;

import org.com.marcosdemo.services.NumbersService;
import org.com.marcosdemo.utils.NumbersUtils;
import org.com.marcosdemo.validators.NumbersValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class NumbersConfig {

    @Bean
    public NumbersService getNumbersService(NumbersValidator numberValidator, NumbersUtils numbersUtils) {
        return new NumbersService(numberValidator, numbersUtils);
    }

    @Bean
    public NumbersUtils getNumbersUtils() {
        return new NumbersUtils();
    }

    @Bean
    public NumbersValidator getNumbersValidator() {
        return new NumbersValidator();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Meaning Cloud Test")
                .description("Meaning Cloud Numbers REST API")
                .contact(new Contact("Marcos Célio", "www.marcoscelio.net", "vinicius.global@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();

    }

}
