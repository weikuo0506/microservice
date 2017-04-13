package com.walker.microservice.api.config;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by walker on 2017/4/11.
 */
@Configuration
@EnableWebMvc //Adding this annotation to an @Configuration class imports the Spring MVC configuration from WebMvcConfigurationSupport
public class WebConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http:/www.weikuo.com")
                .allowedMethods("GET", "POST");
    }
}
