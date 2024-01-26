package com.s1.contact.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "contact")
public class Contact {
    @JacksonXmlProperty(isAttribute = true,localName = "key")
    private long contactId;
    private String name;
    private String phoneNumber;
    private String address;
}
