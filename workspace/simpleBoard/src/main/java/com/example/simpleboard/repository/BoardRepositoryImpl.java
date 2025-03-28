package com.example.simpleboard.repository;

import com.example.simpleboard.dto.BoardDTO;
import com.example.simpleboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final BoardMapper boardMapper;

    @Override
    public void insert(BoardDTO board) {
        boardMapper.insert(board);
    }

    @Override
    public List<BoardDTO> findAll(HashMap<String, Object> map) {
        return boardMapper.findAll(map);
    }

    @Override
    public BoardDTO findByNum(int num) {
        return boardMapper.findByNum(num);
    }

    @Override
    public void update(BoardDTO board) {
        boardMapper.update(board);
    }

    @Override
    public void delete(int num) {
        boardMapper.delete(num);
    }

    @Override
    public int getCount(HashMap<String, Object> map) {
        return boardMapper.getCount(map);
    }
}
