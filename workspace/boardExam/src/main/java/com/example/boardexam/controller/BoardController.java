package com.example.boardexam.controller;


import com.example.boardexam.dto.BoardDTO;
import com.example.boardexam.model.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    // lombok이 생성자를 통해 주입시킬 때 쓰는 상수 (@RequiredArgsConstructor 어노테이션 필요)
    private final BoardService boardService;

    @GetMapping("boardInsert")
    public String getInsert() {
        log.info("boardInsert called");
        return "board/boardWrite";
    }

    @PostMapping("boardInsert")
    public String postInsert(@ModelAttribute BoardDTO board) {
        log.info(board);
        boardService.insert(board);
        return "redirect:boardList";
    }

    @GetMapping("boardList")
    public String getList(
                Model model,
                @RequestParam(value = "searchField", defaultValue = "subject") String searchField,
                @RequestParam(value = "searchWord", defaultValue = "") String searchWord
            ) {
        HashMap<String, String> map = new HashMap<>();
        map.put("searchField", searchField);
        map.put("searchWord", searchWord);
        List<BoardDTO> bList = boardService.searchList(map);
        int count = boardService.searchCount(map);
        model.addAttribute("bArr", bList);
        model.addAttribute("count", count);
        return "board/boardList";
    }

    @GetMapping("boardView")
    public String getView(@RequestParam("num") int num, Model model) {
        BoardDTO board = boardService.boardGet(num);
        model.addAttribute("board", board);
        return "board/boardView";
    }

    @GetMapping("boardUpdate")
    public String getUpdate(@RequestParam("num") int num, Model model) {
        BoardDTO board = boardService.boardGet(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PostMapping("boardUpdate")
    public String postUpdate(@ModelAttribute BoardDTO board) {
        boardService.update(board);
        return "redirect:boardList";
    }

    @GetMapping("boardDelete")
    public String boardDelete(@RequestParam("num") int num) {
        boardService.delete(num);
        return "redirect:boardList";
    }

}
