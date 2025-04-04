package com.example.simpleboard.mapper;

import com.example.simpleboard.dto.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
//    추가
    @Insert("INSERT INTO member(id, password, name, address) VALUES(#{id}, #{password}, #{name}, #{address})")
    void join(MemberDTO member);

//    아이디 중복 확인
    @Select("SELECT COUNT(*) FROM member WHERE id = #{id}")
    int idCheck(String id);

//    로그인 체크
    @Select("SELECT * FROM member WHERE id = #{id}")
    MemberDTO loginCheck(String id);

//    정보 수정
    @Update("UPDATE member SET password = #{password}, name = #{name}, address = #{address} WHERE id = #{id}")
    void update(MemberDTO member);
}
