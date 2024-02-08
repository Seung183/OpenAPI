package com.s1.contact.Interceptor;

import com.s1.contact.service.ApiKeyProcessor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class ApiKeyInterceptor implements HandlerInterceptor {

    private final ApiKeyProcessor apiKeyProcessor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String origin = (String) request.getHeader("Origin");
        System.out.println("origin = " + origin);
        String apiKey = request.getParameter("key");
        System.out.println("apiKey = " + apiKey);
        apiKeyProcessor.checkAPIKey(origin, apiKey);

        return true;
    }

}
