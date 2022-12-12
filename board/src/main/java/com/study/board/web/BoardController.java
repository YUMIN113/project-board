package com.study.board.web;

import com.study.board.dto.BoardResponseDto;
import com.study.board.dto.BoardSaveRequestDto;
import com.study.board.dto.BoardUpdateRequestDto;
import com.study.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("form")
    public String save(BoardSaveRequestDto boardSaveRequestDto) {
        boardService.enrollBoard(boardSaveRequestDto);
        return "redirect:/list";
    }

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("boardResponseDtos", boardService.getBoardResponseDtoList());
    }

    @GetMapping("detail")
    public Map detail(Long no) throws Exception {

       BoardResponseDto boardResponseDto = boardService.getBoardResponseDtoNo(no);
       if (boardResponseDto == null) {
           throw new Exception("해당 번호의 게시글이 없습니다!");
       }

       Map map = new HashMap();
       map.put("boardResponseDto", boardResponseDto);
       return map;
    }

//    @PostMapping("update")
//    public String update(Long no, BoardUpdateRequestDto boardUpdateRequestDto) {
//        boardService.update(no, boardUpdateRequestDto);
//
//        return "redirect:list";
//    }

    @GetMapping("delete")
    public String delete(Long no) {
        boardService.delete(no);

        return "redirect:list";
    }

}
