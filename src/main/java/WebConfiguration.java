import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/swagger-ui/**")
                        .allowedOrigins("https://bankline-api-production-3838.up.railway.app/")
                        .allowedHeaders("Authorization", "Content-Type", "Accept")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
