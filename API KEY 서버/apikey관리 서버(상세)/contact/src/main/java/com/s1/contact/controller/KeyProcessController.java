package com.s1.contact.controller;

import com.s1.contact.domain.ApiKeyVO;
import com.s1.contact.service.ApiKeyProcessor;
import com.s1.contact.util.ApiKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/key")
@RequiredArgsConstructor
public class KeyProcessController {
    private final ApiKeyProcessor apiKeyProcessor;

    @PostMapping()
    public String generateKey(@RequestParam("hostname") String hostname, Model model) throws Exception {
        String apiKey = apiKeyProcessor.requestNewAPIKey(hostname);

        model.addAttribute("key", apiKey);

        return "result";
    }

    @GetMapping()
    public String getForm(){
        return "index";
    }

}
