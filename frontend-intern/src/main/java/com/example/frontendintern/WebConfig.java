package com.example.frontendintern;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/register")
                .allowedOrigins("http://localhost:8080") // İzin verilen kaynaklar (origins) buraya eklenir
                .allowedMethods("POST") // İzin verilen HTTP metotları buraya eklenir
                .allowCredentials(true); // Eğer isteğe kimlik bilgileri (credentials) eklenecekse true olarak ayarlanır, yoksa false
    }

}
