package com.s1.contact.service;

import com.s1.contact.dao.ContactRepository;
import com.s1.contact.domain.Contact;
import com.s1.contact.domain.ContactList;
import com.s1.contact.domain.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Result save(Contact contact){

        Result result = new Result("성공","","");
        try{
            Contact c = contactRepository.save(contact);
            result.setMessage("연락처 추가 성공. 추가된 연락처 일련번호 : " + c.getContactId());
            result.setKey(""+c.getContactId());
        }catch (Exception e){
            result.setStatus("실패");
            result.setMessage(e.getMessage());
            result.setKey("");
            throw new RuntimeException("연락처 추가 실패", e);
        }

        return result;
    }
}
