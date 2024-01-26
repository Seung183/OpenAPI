package com.s1.contact.service;

import com.s1.contact.dao.ContactRepository;
import com.s1.contact.domain.Contact;
import com.s1.contact.domain.ContactList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactList getContactList(){
        List<Contact> contacts = contactRepository.findAll();
        ContactList contactList = new ContactList(contacts.size(),contacts);

        return contactList;
    }
    public List<Contact> getContactList(int pageNum, int pageSize){
        return contactRepository.findAll();
    }

    public Contact getContactOne(Long contactId){
        return contactRepository.findById(contactId);
    }
}
