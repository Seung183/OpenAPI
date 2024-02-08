package com.s1.contact.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s1.contact.domain.ApiKeyInfo;
import com.s1.contact.service.GetResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class getResourceController {
    private final GetResourceService getResourceService;
    @GetMapping("/resource")
    public String getResourceForm(Model model) throws URISyntaxException, IOException, InterruptedException {

        ApiKeyInfo apiKeyInfo = getResourceService.getResouce();

        model.addAttribute("apiKeyInfo", apiKeyInfo);

        System.out.println("apiKeyInfo.getHostName() = " + apiKeyInfo.getHostName());

        return "test";
    }

}
