package com.s1.contact.service;

import com.s1.contact.dao.ContactDAO;
import com.s1.contact.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactDAO contactDAO;

    public List<Contact> getContactList(){
        return contactDAO.getContactList();
    }
    public List<Contact> getContactList(int pageNum, int pageSize){
        return contactDAO.getContactList(pageNum, pageSize);
    }
    public int getContactCount(){
        return contactDAO.getContactCount();
    }
    public Contact getContactOne(Contact c){
        return contactDAO.getContactOne(c);
    }
    public long insertContact(Contact c) {
        return contactDAO.insertContact(c);
    }
    public int updateContact(Contact c) {
        return contactDAO.updateContact(c);
    }
    public int deleteContact(Contact c) {
        return contactDAO.deleteContact(c);
    }
}
