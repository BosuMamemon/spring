package com.example.simpleboard.service;

import com.example.simpleboard.dto.CommentDTO;
import com.example.simpleboard.mapper.BoardMapper;
import com.example.simpleboard.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final BoardMapper boardMapper;

    @Override
    @Transactional
    public void insert(CommentDTO comment) {
        boardMapper.replycount(comment.getBnum(), 1);
        commentMapper.insert(comment);
    }

    @Override
    public List<CommentDTO> selectAll(int bnum) {
        return commentMapper.selectAll(bnum);
    }

    @Override
    @Transactional
    public void delete(int cnum) {
        CommentDTO comment = commentMapper.findByCnum(cnum);
        boardMapper.replycount(comment.getBnum(), -1);
        commentMapper.delete(cnum);
    }
}
