package com.example.simpleboard.controller;

import com.example.simpleboard.dto.BoardDTO;
import com.example.simpleboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @GetMapping("insert")
    public String getInsert() {
        return "board/boardWrite";
    }

    @PostMapping("insert")
    public String postInsert(@ModelAttribute BoardDTO board) {
        boardService.insert(board);
        return "redirect:list";
    }

    @GetMapping("list")
    public String getList(
            @RequestParam(value = "field", defaultValue = "title") String field,
            @RequestParam(value = "word", defaultValue = "") String word,
            Model model
    ) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("field", field);
        map.put("word", word);
        System.out.println(map.get("word"));
        List<BoardDTO> bArr = boardService.findAll(map);
        int count = boardService.getCount(map);
        model.addAttribute("bArr", bArr);
        model.addAttribute("count", count);
        return "board/boardList";
    }

    @GetMapping("view")
    public String getView(@RequestParam("num") int num, Model model) {
        BoardDTO board = boardService.findByNum(num);
        model.addAttribute("board", board);
        return "board/boardView";
    }

    @GetMapping("update/{num}")
    public String getUpdate(@PathVariable("num") int num, Model model) {
        BoardDTO board = boardService.update(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PutMapping("update")
    @ResponseBody
    public int postUpdate(@RequestBody BoardDTO board) {
//        요청에서 데이터를 받아올 땐 RequestBody 어노테이션으로 JSON 객체를 파싱시켜줘야 함
        boardService.update(board);
        log.info(board);
        return board.getNum();
    }

    @DeleteMapping("delete/{num}")
    @ResponseBody   // 리스폰스가 view가 아니라 JSON을 보낸다는 걸 알려주는 어노테이션
//    클라이언트와 핸들러를 오가는 자료형을 변환시켜주는 라이브러리(jackson databind)가 있어야 함
    public int delete(@PathVariable("num") int num) {
        boardService.delete(num);
        return num;
    }
}
