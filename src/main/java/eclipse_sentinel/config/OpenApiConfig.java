package eclipse_sentinel.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Eclipse Sentinel API")
                                .version("1.0")
                                .description("API de monitoramento e prevenção de desastres naturais")
                                .contact(
                                        new Contact()
                                                .name("FIAP - Eclipse Sentinel")
                                )
                );
    }
}