package com.example.springsecurity.domain;

import com.example.springsecurity.dto.CustomUser;
import com.example.springsecurity.dto.MemberDTO;
import com.example.springsecurity.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        MemberDTO memberDTO = memberMapper.read(username);
        log.info("memberDTO: " + memberDTO);
        CustomUser user = new CustomUser(memberDTO);
        log.info("user: " + user);

        return memberDTO == null ? null : user;
    }
}
