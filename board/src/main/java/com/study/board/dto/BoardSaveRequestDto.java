package com.study.board.dto;

import com.study.board.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter // DTO 에서는 Setter 사용해야 함.
public class BoardSaveRequestDto {

    public BoardSaveRequestDto() {}

    private String title;
    private String writer;
    private String content;

    @Builder
    public BoardSaveRequestDto (String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .build();
    }
}
