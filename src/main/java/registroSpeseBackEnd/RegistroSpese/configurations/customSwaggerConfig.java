package registroSpeseBackEnd.RegistroSpese.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class customSwaggerConfig
{
    @Bean
    public OpenAPI customSwagger()
    {
        return new OpenAPI()
                .info(new Info()
                        .title("API Registro Spese")
                        .version("0.1.0")
                        .description("Documentazione Ufficiale delle API per l'applicazione del Registro Spese"));
                        /*.contact(new Contact()
                                .name("")
                                .email("")));*/
    }
}
