package com.s1.contact.controller;

import com.s1.contact.domain.Contact;
import com.s1.contact.domain.ContactList;
import com.s1.contact.domain.Result;
import com.s1.contact.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ContactList GetContactAllAPI(){
        return contactService.getContactList();
    }


    @PostMapping()
    public Result InsertContactAPI(@RequestBody Contact c){
        return contactService.save(c);
    }
}
