package com.example.simpleboard.service;

import com.example.simpleboard.dto.BoardDTO;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
//    추가
    public void insert(BoardDTO board);

//    전체보기
    public List<BoardDTO> findAll(HashMap<String, Object> map);

//    상세보기
    public BoardDTO findByNum(int num);

//    수정
    public void update(BoardDTO board);

//    수정폼
    public BoardDTO update(int num);

//    삭제
    public void delete(int num);

//    갯수
    public int getCount(HashMap<String, Object> map);
}
