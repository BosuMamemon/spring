package com.example.simpleboard.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
//    필드
    private int num;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int hitCount;
    private int replyCount;
}
