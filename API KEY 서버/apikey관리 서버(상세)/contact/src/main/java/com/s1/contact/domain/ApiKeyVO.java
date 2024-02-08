package com.s1.contact.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyVO {

    private String hostName;
    private String apiKey;
    private int count;

}
