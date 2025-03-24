package com.example.springexam01.model;

import com.example.springexam01.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    // SQL 작업들을 가리키는 어노테이션
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

//    추가
    public void insert(Person person) {
        personDAO.dao_insert(person);
    }

//    전체보기
    public List<Person> list() {
        return personDAO.dao_list();
    }

//    뷰
    public Person view(String id) {
        return personDAO.dao_view(id);
    }

//    삭제
    public void delete(String id) {
        personDAO.dao_delete(id);
    }

//    수정
    public void update(Person person) {
        personDAO.dao_update(person);
    }

}
