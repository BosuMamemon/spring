package com.example.simpleboard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private int cnum;
    private String userid;
    private String content;
//    Date형을 JSON으로 파싱하려면 그냥 미리 이 어노테이션을 넣어주면 됨
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date regdate;
    private int bnum;
}
