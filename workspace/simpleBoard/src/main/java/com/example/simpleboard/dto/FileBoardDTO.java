package com.example.simpleboard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FileBoardDTO {
    private int num;
    private String title;
    private String writer;
    private String content;
    private MultipartFile upload;
    private String fileImage;   // 이미지 파일명
}
