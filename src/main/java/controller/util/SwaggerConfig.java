package controller.util;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI configure() {
        return new OpenAPI()
                .info(new Info()
                        .title("Parking")
                        .description("description")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Apache 2.0")
                        )
                );
    }}

