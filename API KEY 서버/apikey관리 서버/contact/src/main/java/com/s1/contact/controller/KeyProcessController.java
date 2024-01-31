package com.s1.contact.controller;

import com.s1.contact.service.ApiKeyProcessor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/key")
@RequiredArgsConstructor
public class KeyProcessController {
    private final ApiKeyProcessor apiKeyProcessor;

    @PostMapping()
    public String generateKey(@RequestBody String hostname, Model model){

        String key = apiKeyProcessor.generateNewKey(hostname);
        model.addAttribute("key", key);

        return "result";
    }
    @GetMapping()
    public String generateKeyForm(){
        return "index";
    }

}
