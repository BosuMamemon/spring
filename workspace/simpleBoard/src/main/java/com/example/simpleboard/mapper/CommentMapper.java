package com.example.simpleboard.mapper;

import com.example.simpleboard.dto.CommentDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.xml.stream.events.Comment;
import java.util.List;

@Mapper
public interface CommentMapper {
//    추가
    @Insert("INSERT INTO comments(userid, content, bnum) VALUES(#{userid}, #{content}, #{bnum})")
    void insert(CommentDTO comment);

//    전체보기
    @Select("SELECT * FROM comments WHERE bnum = #{bnum}")
    List<CommentDTO> selectAll(int bnum);

//    삭제
    @Delete("DELETE FROM comments WHERE cnum = #{cnum}")
    void delete(int cnum);

//    열 가져오기
    @Select("SELECT * FROM comments WHERE cnum = #{cnum}")
    CommentDTO findByCnum(int cnum);
}
