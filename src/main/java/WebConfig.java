import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

//    @Value("${cors.originPatterns:default}")
//    private String corsOriginPatterns = "";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        var allowOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(false);
    }
}
