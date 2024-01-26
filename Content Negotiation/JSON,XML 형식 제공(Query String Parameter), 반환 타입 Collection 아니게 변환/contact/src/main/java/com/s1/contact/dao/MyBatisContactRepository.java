package com.s1.contact.dao;

import com.s1.contact.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyBatisContactRepository implements ContactRepository{
    private final ContactMapper contactMapper;

    @Override
    public Contact save(Contact contact) {
        contactMapper.save(contact);

        return contact;
    }

    @Override
    public Contact findById(Long id) {
        return contactMapper.findById(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactMapper.findAll();
    }
}
