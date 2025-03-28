package com.example.boardexam.model;

import com.example.boardexam.dto.BoardDTO;
import com.example.boardexam.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    public final BoardMapper boardMapper;

    @Override
    public void dao_insert(BoardDTO board) {
        boardMapper.insertBoard(board);
    }

    @Override
    public List<BoardDTO> dao_boardList() {
        return boardMapper.boardList();
    }

    @Override
    public BoardDTO dao_boardGet(int num) {
        return boardMapper.getBoard(num);
    }

    @Override
    public void dao_update(BoardDTO board) {
        boardMapper.updateBoard(board);
    }

    @Override
    public void dao_delete(int num) {
        boardMapper.deleteBoard(num);
    }

    @Override
    public int dao_count() {
        return boardMapper.countBoard();
    }

    @Override
    public List<BoardDTO> dao_searchList(HashMap<String, String> map) {
        return boardMapper.searchList(map);
    }

    @Override
    public int dao_searchCount(HashMap<String, String> map) {
        return boardMapper.searchCount(map);
    }
}
