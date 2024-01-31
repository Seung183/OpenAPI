package com.s1.contact.service;

import com.s1.contact.domain.ApiKey;
import com.s1.contact.repository.ApiKeyMapper;
import com.s1.contact.repository.ApiKeyRepositoryImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiKeyProcessor {

    private final ApiKeyRepositoryImpl apiKeyRepository;

    public String generateNewKey(String hostname){
        String newApiKey = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());

        ApiKey apiKey = new ApiKey();

        apiKey.setApiKey(newApiKey);
        apiKey.setHostName(hostname);

        apiKeyRepository.save(apiKey);

        return newApiKey;
    }


    public String requestNewApiKey(ApiKey apiKey){
        String newApiKey = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
        apiKey.setApiKey(newApiKey);

        apiKeyRepository.save(apiKey);

        return newApiKey;
    }

    public void checkAPiKey(String hostName, String apikey){
        ApiKey findApiKey = apiKeyRepository.findByApiKey(apikey);

        if(findApiKey == null){
            System.out.println("등록되지 않은 api key입니다.");
        }
        if(hostName == null){
            System.out.println("등록되지 않은 origin입니다.");
        }
        if(findApiKey.getCount() >= 10){
            System.out.println("최대 요청 초과");
        }
    }

}
