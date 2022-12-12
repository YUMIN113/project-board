package com.study.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardUpdateRequestDto {

    public BoardUpdateRequestDto() {}

    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
