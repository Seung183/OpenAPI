package com.s1.contact.controller;


import com.s1.contact.domain.ApiKeyVO;
import com.s1.contact.repository.ApiKeyRepositoryImpl;
import com.s1.contact.service.ApiKeyProcessor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
@CrossOrigin("http://test.com:8000")
public class ResourceController {

    private final ApiKeyRepositoryImpl apiKeyRepository;

    @GetMapping()
    public ApiKeyVO API(HttpServletRequest request){
        return apiKeyRepository.findByApiKey(request.getParameter("key"));
    }
}
