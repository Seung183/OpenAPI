package com.s1.contact.repository;

import com.s1.contact.domain.ApiKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiKeyMapper {
    void save(ApiKey apiKey);

    ApiKey findByApiKey(String apiKey);

    void update(ApiKey apiKey);

}
