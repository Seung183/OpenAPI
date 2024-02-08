package com.s1.contact.repository;

import com.s1.contact.domain.ApiKeyVO;
import com.s1.contact.util.ApiKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApiKeyRepositoryImpl implements ApiKeyMapper{
    private final ApiKeyMapper apiKeyMapper;

    @Override
    public void save(ApiKeyVO apiKeyVO) throws ApiKeyException {
        apiKeyMapper.save(apiKeyVO);
    }

    @Override
    public ApiKeyVO findByApiKey(String apiKey) throws ApiKeyException{
        return apiKeyMapper.findByApiKey(apiKey);
    }

    @Override
    public void update(String apiKey) throws ApiKeyException{
        apiKeyMapper.update(apiKey);
    }
}
