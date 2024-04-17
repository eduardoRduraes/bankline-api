import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String corsOriginPatterns = "https://bankline-api-production-3838.up.railway.app";


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                .allowedMethods("GET","POST","PUT")
                .allowedMethods("*")
                .allowedOrigins(allowOrigins)
                .allowCredentials(true);
    }
}
