package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // SQL문 하나를 처리하는 레이어를 가리키는 어노테이션
public class PersonDAO {

    @Autowired
    private SqlSession sqlMapper;

//    추가
    public void dao_insert(Person person) {
        sqlMapper.insert("personInsert", person);
    }

//    전체보기
    public List<Person> list() {
        return sqlMapper.selectList("personList");
    }

}

