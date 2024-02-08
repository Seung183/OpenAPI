package com.s1.contact.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ApiKeyInfo {

    private String hostName;
    private String apiKey;
    private int count;
}
