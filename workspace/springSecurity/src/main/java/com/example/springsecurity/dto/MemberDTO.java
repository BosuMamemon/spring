package com.example.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String userid;
    private String username;
    private String userpw;
    private String regdate;
    private String updatedate;
    private boolean enabled;
    private List<AuthDTO> authList;
}
