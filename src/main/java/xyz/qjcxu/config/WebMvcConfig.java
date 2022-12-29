package xyz.qjcxu.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @since 22.12.28 20:18
 */
public class WebMvcConfig extends WebMvcConfigurationSupport {
  @Override
  protected void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedHeaders("*")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
    super.addCorsMappings(registry);
  }
}
