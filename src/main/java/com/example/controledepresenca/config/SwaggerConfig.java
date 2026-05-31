package com.example.controledepresenca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info; // Importação correta para OpenAPI 3
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().
						title(" Controle de Presenca ").
						description(" Controle de Presenca dos Colaboradores RPM e GN ").
						version("1.0"));
		
		/*OpenAPI openAPI = new OpenAPI()
			    .info(new Info()
			        .title("Minha API")
			        .version("1.0")
			        .description("Documentação da API usando OpenAPI 3"));*/

	}

}
