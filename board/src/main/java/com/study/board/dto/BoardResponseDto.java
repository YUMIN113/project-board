package com.study.board.dto;

import com.study.board.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long no;

    private String title;

    private String writer;

    private String content;

    public BoardResponseDto(Board entity) {
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.content = entity.getContent();
    }

    @Builder
    public BoardResponseDto(Long no, String title, String writer, String content) {
        this.no =no;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
