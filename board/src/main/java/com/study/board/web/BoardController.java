package com.study.board.web;

import com.study.board.dto.BoardSaveRequestDto;
import com.study.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("form")
    public String save(BoardSaveRequestDto boardSaveRequestDto) {
        boardService.save(boardSaveRequestDto);
        return "redirect:/";
    }
}
