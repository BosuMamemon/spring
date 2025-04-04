
package com.example.simpleboard.service;

import com.example.simpleboard.dto.MemberDTO;
import com.example.simpleboard.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void join(MemberDTO member) {
        memberMapper.join(member);
    }

    @Override
    public int idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public MemberDTO loginCheck(String id) {
        return memberMapper.loginCheck(id);
    }

    @Override
    public void update(MemberDTO member) {
        memberMapper.update(member);
    }
}
