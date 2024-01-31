package com.s1.contact.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiKey {

    private String hostName;
    private String apiKey;
    private int count;

    public ApiKey(String hostName, String apiKey) {
        this.hostName = hostName;
        this.apiKey = apiKey;
    }
}
