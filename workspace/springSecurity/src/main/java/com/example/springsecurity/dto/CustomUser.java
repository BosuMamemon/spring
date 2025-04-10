package com.example.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Getter @Setter
public class CustomUser extends User {
    private MemberDTO memberDTO;

    public CustomUser(MemberDTO member) {
        super(
                member.getUsername(),
                member.getUserpw(),
                member.getAuthList()
                        .stream()
                        .map(authDTO -> new SimpleGrantedAuthority(authDTO.getAuth()))
                        .collect(Collectors.toList())
        );
        this.memberDTO = member;
    }
}
