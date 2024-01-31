package com.s1.contact.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * CORS 적용 <- Cross Origin 문제
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/contacts/**")
                .allowedOrigins("http://client:8000")
                .allowedMethods("GET","POST")
                .allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * 정적 리소스 관리
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(20);
    }
}
