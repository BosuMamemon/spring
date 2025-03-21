package com.example.springexam01.controller;

import com.example.springexam01.dto.Person;
import com.example.springexam01.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired  // 스프링 컨테이너 안에 있는 PersonService라는 객체와 같은 자료형인지 확인해서 연결시켜주는 어노테이션
    private PersonService personService;

//    추가 폼
    @GetMapping("pInsert")
    public String getInsert() {
        return "insert";
    }

//    전체보기 폼
    @GetMapping("pList")
    public String getList(Model model) {
        List<Person> personList = personService.list();
        model.addAttribute("personList", personList);
        return "list";
    }
    
//    추가
    @PostMapping("pInsert")
    public String postInsert(@ModelAttribute Person person) {   // 객체 안에 setAttribute를 그냥 주입시켜버리는 어노테이션
        personService.insert(person);
        return "redirect:pList";    // 스프링은 기본값이 forward라서 리다이렉트를 하려면 이렇게 따로 써줘야함
    }

}
