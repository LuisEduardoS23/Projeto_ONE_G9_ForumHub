package br.com.luisEduardo.ForumHub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                .title("Fórum Hub API")
                .description("API Rest da aplicação Fórum Hub, proposto como desafio final da formação backend Java na Oracle ONE G9." +
                        " O sistema possui as funcionalidades de cadastro e login de Usuários e funções de cadastro, detalhamento e remoção de Cursos, Tópicos, Respostas e Usuários do fórum.")
                .contact(new Contact()
                        .name("Luis Eduardo")
                        .email("luisesoares4@gmail.com")));
    }



}
