package com.example.boardexam.mapper;

import com.example.boardexam.dto.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {

//    추가
    @Insert("INSERT INTO board(userid, subject, content) VALUES(#{userid}, #{subject}, #{content})")
    void insertBoard(BoardDTO board);

//    전체보기
    @Select("SELECT * FROM board ORDER BY num DESC")
    List<BoardDTO> boardList();

//    상세보기
    @Select("SELECT * FROM board WHERE num = #{num}")
    BoardDTO getBoard(int num);

//    수정
    @Update("UPDATE board SET userid = #{userid}, subject = #{subject}, content = #{content} WHERE num = #{num}")
    void updateBoard(BoardDTO board);

//    삭제
    @Delete("DELETE FROM board WHERE num = #{num}")
    void deleteBoard(int num);

//    개수
    @Select("SELECT COUNT(*) FROM board")
    int countBoard();

//    검색 관련 (어노테이션으로 그냥 if문 쓰면 그만이긴 한데 이번엔 mybatis 문법으로 매핑해보기로 함)
    List<BoardDTO> searchList(HashMap<String, String> map);
    int searchCount(HashMap<String, String> map);

}
