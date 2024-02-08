package com.s1.contact.repository;

import com.s1.contact.domain.ApiKeyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApiKeyMapper {
    void save(ApiKeyVO apiKeyVO);

    ApiKeyVO findByApiKey(String apiKey);

    void update(String apiKey);

}
