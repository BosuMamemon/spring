package com.example.simpleboard.controller;

import com.example.simpleboard.dto.MemberDTO;
import com.example.simpleboard.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {
    @Autowired
    private MemberService memberService;
    
//    join view
    @GetMapping("join")
    public String getJoin() {
        return "/member/memberJoin";
    }

//    join method
    @PostMapping("join") @ResponseBody
    public String postJoin(@RequestBody MemberDTO member) {
        int flag = memberService.idCheck(member.getId());
        if(flag != 0) { return "fail"; }
        memberService.join(member);
        return "done";
    }
    
//    login view
    @GetMapping("login")
    public String getLogin() {
        return "/member/memberLogin";
    }

//    login method
    @PostMapping("login") @ResponseBody
    public String postLogin(@RequestBody MemberDTO loginMember, HttpSession session) {
        MemberDTO dbMember = memberService.loginCheck(loginMember.getId());
        if(dbMember == null) {
//          회원 없음
            return "notExist";
        }
        if(dbMember.getPassword().equals(loginMember.getPassword())) {
//          성공
            session.setAttribute("sessionMember", dbMember);
            return "done";
        } else {
//          비밀번호 오류
            return "fail";
        }
    }

//    logout
    @GetMapping("logout") @ResponseBody
    public String getLogout(HttpSession session) {
        session.removeAttribute("sessionMember");
        return "done";
    }

//    update view
    @GetMapping("update")
    public String getUpdate() {
        return "/member/memberUpdate";
    }

//    update method
    @PutMapping("update") @ResponseBody
    public String postUpdate(@RequestBody MemberDTO member, HttpSession session) {
        memberService.update(member);
        MemberDTO sessionMember = memberService.loginCheck(member.getId());
        session.removeAttribute("sessionMember");
        session.setAttribute("sessionMember", sessionMember);
        return "done";
    }
}
