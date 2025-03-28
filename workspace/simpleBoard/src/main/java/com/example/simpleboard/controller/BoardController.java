package com.example.simpleboard.controller;

import com.example.simpleboard.dto.BoardDTO;
import com.example.simpleboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
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

    @GetMapping("update")
    public String getUpdate(@RequestParam("num") int num, Model model) {
        BoardDTO board = boardService.findByNum(num);
        model.addAttribute("board", board);
        return "board/boardUpdate";
    }

    @PostMapping("update")
    public String postUpdate(@ModelAttribute BoardDTO board) {
        boardService.update(board);
        return "redirect:list";
    }

    @GetMapping("delete")
    public String getDelete(@RequestParam("num") int num) {
        boardService.delete(num);
        return "redirect:list";
    }
}
