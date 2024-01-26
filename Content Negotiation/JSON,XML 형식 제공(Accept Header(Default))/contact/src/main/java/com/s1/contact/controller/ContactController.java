package com.s1.contact.controller;

import com.s1.contact.domain.Contact;
import com.s1.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @GetMapping("{contactId}")
    public Contact GetContactOneAPI(@PathVariable("contactId") long contactId){
        return contactService.getContactOne(contactId);
    }

    @GetMapping()
    public List<Contact> GetContactAllAPI(){
        return contactService.getContactList();
    }
}
