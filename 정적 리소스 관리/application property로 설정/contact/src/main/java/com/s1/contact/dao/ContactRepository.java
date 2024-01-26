package com.s1.contact.dao;

import com.s1.contact.domain.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    Contact findById(Long id);
    List<Contact> findAll();

}
