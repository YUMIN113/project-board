package com.study.board.service;

import com.study.board.domain.Board;
import com.study.board.dto.BoardResponseDto;
import com.study.board.repository.BoardRepository;
import com.study.board.dto.BoardSaveRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void enrollBoard(BoardSaveRequestDto boardSaveRequestDto) {
        boardRepository.save(boardSaveRequestDto.toEntity());
    }

    // BoardRepository 는 Board 형이기 때문에 BoardResponseDto 로 형변환 해야 함.
    public List<BoardResponseDto> getBoardResponseDtoList() {
        return boardRepository.findAll().stream().map(it -> {
            return new BoardResponseDto(it);
        }).collect(Collectors.toList());
    }

    // BoardRepository 는 Board 형이기 때문에 BoardResponseDto 로 형변환 해야 함.
    public BoardResponseDto getBoardResponseDtoNo(Long no) {
        Optional<Board> boardWrapper = boardRepository.findById(no);
        Board board = boardWrapper.get();

        return BoardResponseDto.builder()
                .no(board.getNo())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
    }
}
