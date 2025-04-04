package com.example.simpleboard.dto;

import lombok.*;

import java.util.Date;

@Data
public class MemberDTO {
    private String id;
    private String name;
    private String password;
    private String address;
    private Date regdate;
}
