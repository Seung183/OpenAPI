package com.s1.contact.dao;

import com.s1.contact.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContactDAO {

    @Autowired
    private final SqlSession sqlSession;

    public List<Contact> getContactList(){
        return sqlSession.selectList("contact.selectall");
    }

    public List<Contact> getContactList(int pageNum, int pageSize){
        int offset = pageSize * (pageNum - 1); // 시작 인덱스 번호
        int limit = pageSize;

        return sqlSession.selectList("contact.selectall",null,new RowBounds(offset,limit));
    }

    public int getContactCount(){
        return sqlSession.selectOne("contact.selectcnt");
    }

    public Contact getContactOne(Contact c){
        return sqlSession.selectOne("contact.selectone", c);
    }

    public long insertContact(Contact c){
        sqlSession.insert("contact.insert", c);
        return c.getContactId();
    }

    public int updateContact(Contact c){
        return sqlSession.update("contact.update", c);
    }

    public int deleteContact(Contact c){
        return sqlSession.delete("contact.delete", c);
    }
}
/**
 * List<Contact>와 같은 컬렉션 형태는 XML 직렬화 불가능
 */