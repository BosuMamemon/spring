package com.example.simpleboard.repository;

import com.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardRepository {
    //    추가
    void insert(BoardDTO board);

    //    전체보기
    List<BoardDTO> findAll(HashMap<String, Object> map);

    //    상세보기
    BoardDTO findByNum(int num);

    //    수정
    void update(BoardDTO board);

    //    수정폼
    BoardDTO update(int num);

    //    삭제
    void delete(int num);

    //    갯수
    int getCount(HashMap<String, Object> map);

    //    조회수 증가
    void updateReadcount(int num);

}
