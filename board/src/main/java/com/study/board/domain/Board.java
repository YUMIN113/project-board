package com.study.board.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class Board {

    public Board() {
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 500) @NotNull
    private String title;

    @Column @NotNull
    private String writer;

    @Column(columnDefinition = "TEXT") @NotNull
    private String content;

    @Builder
    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}


