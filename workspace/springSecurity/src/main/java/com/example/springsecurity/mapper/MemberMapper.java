package com.example.springsecurity.mapper;

import com.example.springsecurity.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDTO read(String userid);
}
