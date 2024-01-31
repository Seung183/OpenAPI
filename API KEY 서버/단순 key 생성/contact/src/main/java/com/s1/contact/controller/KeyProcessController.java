package com.s1.contact.controller;

import com.s1.contact.service.ApiKeyProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/key")
@RequiredArgsConstructor
public class KeyProcessController {
    private final ApiKeyProcessor apiKeyProcessor;

    @PostMapping()
    public void generateKey(){
        apiKeyProcessor.generateNewKey();
    }

}
