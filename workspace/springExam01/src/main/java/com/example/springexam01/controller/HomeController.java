package com.example.springexam01.controller;

import com.example.springexam01.dto.Person;
import com.example.springexam01.model.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired  // 스프링 컨테이너 안에 있는 PersonService라는 객체와 같은 자료형인지 확인해서 연결시켜주는 어노테이션
    private PersonService personService;

//    Person 추가 폼
    @GetMapping("pInsert")
    public String getPInsert() {
        return "insert";
    }

//    Person 전체보기 폼으로 이동
    @GetMapping("pList")
    public String getPList(Model model) {
        List<Person> personList = personService.list();
        model.addAttribute("personList", personList);
        return "list";
    }
    
//    Person 추가
    @PostMapping("pInsert")
    public String postPInsert(@ModelAttribute Person person) {   // 객체 안에 setAttribute를 그냥 주입시켜버리는 어노테이션
        personService.insert(person);
        return "redirect:pList";    // 스프링은 기본값이 forward라서 리다이렉트를 하려면 이렇게 따로 써줘야함
    }

//    Person 뷰
    @GetMapping("pView")
    public String getPView(@RequestParam("id") String id, Model model) {
        Person person = personService.view(id);
        model.addAttribute("person", person);
        return "view";
    }

//    Person 삭제
    @GetMapping("pDelete")
    public String getPDelete(@RequestParam("id") String id, Model model) {
        personService.delete(id);
        return "redirect:pList";
    }
    
//    Person 수정 폼으로 이동
    @GetMapping("pUpdate")
    public String getPUpdate(@RequestParam("id") String id, Model model) {
        model.addAttribute(personService.view(id));
        return "update";
    }
    
//    Person 수정
    @PostMapping("pUpdate")
    public String postPUpdate(@ModelAttribute Person person) {
        personService.update(person);
        return "redirect:pList";
    }

}
