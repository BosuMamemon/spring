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
            "VALUES(${title}, ${writer}, ${content})"
    )
    public void insert(BoardDTO board);

    //    전체보기
    public List<BoardDTO> findAll(HashMap<String, Object> map);

    //    상세보기
    @Select("SELECT * FROM boards WHERE num = ${num}")
    public BoardDTO findByNum(int num);

    //    수정
    @Update("UPDATE boards SET title = '${title}', content = '${content}' WHERE num = ${num}")
    public void update(BoardDTO board);

    //    삭제
    @Delete("DELETE FROM boards WHERE num = ${num}")
    public void delete(int num);

    //    갯수
    public int getCount(HashMap<String, Object> map);
}
