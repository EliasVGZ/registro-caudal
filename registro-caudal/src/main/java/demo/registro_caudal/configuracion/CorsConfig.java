package demo.registro_caudal.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permite todos los endpoints
                        .allowedOrigins("http://localhost:8080", "192.168.1.34:8080","192.168.43.115", "http://10.0.2.2:8080") // Permite solicitudes de estos orígenes
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Permite todos los headers
                        .allowCredentials(true); // Permite el uso de cookies/sesiones
            }
        };
    }
}
