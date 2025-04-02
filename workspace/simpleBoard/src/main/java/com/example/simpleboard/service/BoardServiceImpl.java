package com.example.simpleboard.service;

import com.example.simpleboard.dto.BoardDTO;
import com.example.simpleboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public void insert(BoardDTO board) {
        boardRepository.insert(board);
    }

    @Override
    public List<BoardDTO> findAll(HashMap<String, Object> map) {
        return boardRepository.findAll(map);
    }

    @Override
    public BoardDTO findByNum(int num) {
        boardRepository.updateReadcount(num);
        return boardRepository.findByNum(num);
    }

    @Override
    public void update(BoardDTO board) {
        boardRepository.update(board);
    }

    @Override
    public BoardDTO update(int num) {
        return boardRepository.update(num);
    }

    @Override
    public void delete(int num) {
        boardRepository.delete(num);
    }

    @Override
    public int getCount(HashMap<String, Object> map) {
        return boardRepository.getCount(map);
    }
}
