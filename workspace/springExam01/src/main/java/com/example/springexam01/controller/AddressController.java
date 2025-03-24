package com.example.springexam01.controller;

import com.example.springexam01.dto.Address;
import com.example.springexam01.model.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/address") // 매핑을 할 때 address경로를 타고온 놈들은 여기서 매핑하겠다는 거임
@Controller
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

//    추가 폼으로 가기
    @GetMapping("aInsert")
    public String getInsert() {
        return "/address/insert";
    }

//    추가
    @PostMapping("aInsert")
    public String postInsert(@ModelAttribute Address address) {
        addressService.aInsert(address);
        return "redirect:aList";
    }

//    전체보기
    @GetMapping("aList")
    public String getList(Model model) {
        List<Address> aList = addressService.aList();
        int count = addressService.aCount();
        model.addAttribute("aList", aList);
        model.addAttribute("count", count);
        return "/address/list";
    }

//    뷰 폼으로 가기
    @GetMapping("aView")
    public String getView(@RequestParam("num") int num, Model model) {
        Address address = addressService.aView(num);
        model.addAttribute("address", address);
        return "/address/view";
    }

//    수정
    @PostMapping("aUpdate")
    public String postUpdate(@ModelAttribute Address address) {
        addressService.aUpdate(address);
        return "redirect:aList";
    }

//    삭제
    @GetMapping("aDelete")
    public String getDelete(@RequestParam("num") int num) {
        addressService.aDelete(num);
        return "redirect:aList";
    }

}
