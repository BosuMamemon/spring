package com.example.simpleboard.service;

import com.example.simpleboard.dto.MemberDTO;

public interface MemberService {
//    추가
    void join(MemberDTO member);

//    아이디 중복 확인
    int idCheck(String id);

//    로그인 체크
    MemberDTO loginCheck(String id);

//    정보 수정
    void update(MemberDTO member);
}
