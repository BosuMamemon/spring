package com.example.simpleboard.mapper;

import com.example.simpleboard.dto.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    //    추가
    @Insert(
            "INSERT INTO boards(title, writer, content) " +
            "VALUES(#{title}, #{writer}, #{content})"
    )
    public void insert(BoardDTO board);

    //    전체보기
    public List<BoardDTO> findAll(HashMap<String, Object> map);

    //    상세보기
    @Select("SELECT * FROM boards WHERE num = #{num}")
    public BoardDTO findByNum(int num);

    //    수정
    @Update("UPDATE boards SET title = #{title}, content = #{content} WHERE num = #{num}")
    public void update(BoardDTO board);

    //    수정폼
    @Select("SELECT * FROM boards WHERE num = #{num}")
    public BoardDTO updateForm(int num);

    //    삭제
    @Delete("DELETE FROM boards WHERE num = #{num}")
    public void delete(int num);

    //    갯수
    public int getCount(HashMap<String, Object> map);

//    replycount 증감
    @Update("UPDATE boards SET replycount = replycount + #{amount} WHERE num = #{bnum}")
    void replycount(@Param("bnum") int bnum, @Param("amount") int amount);

//    조회수 증가
    @Update("UPDATE boards SET hitcount = hitcount + 1 WHERE num = #{num}")
    void updateReadcount(int num);
}
