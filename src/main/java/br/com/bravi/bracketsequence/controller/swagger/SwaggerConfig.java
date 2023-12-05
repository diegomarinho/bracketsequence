package br.com.bravi.bracketsequence.controller.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                description = "Serviço responsável pela validação de uma sequência de colchetes balanceada.",
                version = "1.0.0",
                title = "Serviço de Suportes balanceados",
                termsOfService = "https://bravi.com.br/terms/",
                contact = @Contact(
                        name = "API Suportes balanceados",
                        url = "https://www.bravi.com/suporte",
                        email = "suporte@bravi.com.br"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class SwaggerConfig {
}
