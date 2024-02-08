package com.s1.contact.service;

import com.s1.contact.domain.ApiKeyVO;
import com.s1.contact.repository.ApiKeyRepositoryImpl;
import com.s1.contact.util.ApiKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiKeyProcessor {

    private final ApiKeyRepositoryImpl apiKeyRepository;

    public String requestNewAPIKey(String hostname) {
        String newApiKey = DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
        ApiKeyVO apiKeyVO = new ApiKeyVO();
        apiKeyVO.setApiKey(newApiKey);
        apiKeyVO.setHostName(hostname);
        try{
            apiKeyRepository.save(apiKeyVO);
        }catch (Exception e){
            throw new ApiKeyException("이미 등록된 api key 입니다.", "사용자 요청 오류 status code");
        }

        return newApiKey;
    }

    public void checkAPIKey(String hostname, String apikey) throws ApiKeyException{
        ApiKeyVO apiKeyVO = apiKeyRepository.findByApiKey(apikey);
        System.out.println("apiKeyVO key= " + apiKeyVO.getApiKey());
        System.out.println("apiKeyVO host= " + apiKeyVO.getHostName());
        if(apiKeyVO == null){
            throw new ApiKeyException("등록되지 않은 API KEY"," 사용자 요청 오류 status code");
        }
        if(hostname == null || !hostname.equals(apiKeyVO.getHostName())){
            throw new ApiKeyException("등록되지 않은 origin(호스트명) 또는 잘못된 origin 명", " 사용자 요청 오류 status code");
        }
        if(apiKeyVO.getCount() >= 100){
            throw new ApiKeyException("최대 요청 수 추가", " 사용자 요청 오류 status code");
        }
        apiKeyRepository.update(apikey); // 사용자 카운트 증가
    }

}
