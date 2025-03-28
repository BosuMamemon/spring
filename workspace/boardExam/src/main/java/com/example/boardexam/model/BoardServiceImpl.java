package com.example.boardexam.model;

import com.example.boardexam.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor    // lombok이 생성자를 통해 bean 객체를 주입시키도록 해주는 어노테이션
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void insert(BoardDTO board) {
        boardRepository.dao_insert(board);
    }

    @Override
    public List<BoardDTO> boardList() {
        return boardRepository.dao_boardList();
    }

    @Override
    public BoardDTO boardGet(int num) {
        return boardRepository.dao_boardGet(num);
    }

    @Override
    public void update(BoardDTO board) {
        boardRepository.dao_update(board);
    }

    @Override
    public void delete(int num) {
        boardRepository.dao_delete(num);
    }

    @Override
    public int count() {
        return boardRepository.dao_count();
    }

    @Override
    public List<BoardDTO> searchList(HashMap<String, String> map) {
        return boardRepository.dao_searchList(map);
    }

    @Override
    public int searchCount(HashMap<String, String> map) {
        return boardRepository.dao_searchCount(map);
    }
}
