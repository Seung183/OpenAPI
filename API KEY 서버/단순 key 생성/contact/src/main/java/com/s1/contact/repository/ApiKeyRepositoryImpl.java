package com.s1.contact.repository;

import com.s1.contact.domain.ApiKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApiKeyRepositoryImpl implements ApiKeyMapper{
    private final ApiKeyMapper apiKeyMapper;

    @Override
    public void save(ApiKey apiKey) {
        apiKeyMapper.save(apiKey);
    }

    @Override
    public ApiKey findByApiKey(String apiKey) {
        return apiKeyMapper.findByApiKey(apiKey);
    }

    @Override
    public void update(ApiKey apiKey) {
        apiKeyMapper.update(apiKey);
    }
}
