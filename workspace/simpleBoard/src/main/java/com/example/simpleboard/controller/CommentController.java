package com.example.simpleboard.controller;

import com.example.simpleboard.dto.CommentDTO;
import com.example.simpleboard.service.BoardService;
import com.example.simpleboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController // ResponseBody를 리턴값으로 가지는 Controller
@RequestMapping("/reply/*")
@RequiredArgsConstructor
@Log4j2
public class CommentController {
    private final CommentService commentService;
    private final BoardService boardService;

    @PostMapping("insert")
//    아래는 출력값 String 대신 할 수 있는 옵션
    public ResponseEntity<String> postInsert(@RequestBody CommentDTO comment) {
        comment.setUserid("test");
        commentService.insert(comment);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("list/{num}")
    public ResponseEntity<HashMap<String, Object>> getList(@PathVariable("num") int bnum) {
        List<CommentDTO> cList = commentService.selectAll(bnum);
        int count = boardService.update(bnum).getReplyCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("cList", cList);
        map.put("count", count);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("delete/{cnum}")
    public ResponseEntity<Integer> delete(@PathVariable("cnum") int cnum) {
        commentService.delete(cnum);
        return new ResponseEntity<>(cnum, HttpStatus.OK);
    }
}
