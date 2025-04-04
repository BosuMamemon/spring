package com.example.simpleboard.controller;

import com.example.simpleboard.dto.FileBoardDTO;
import com.example.simpleboard.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/file/*")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

//    파일 추가 폼
    @GetMapping("uploadFile")
    public void getUploadFile() {}

//    파일 추가
    @PostMapping("uploadFile")
    public String postUploadFile(@RequestParam("uploads") MultipartFile[] uploads, Model model) {
        String uploadFolder = "C:\\JHM\\Spring\\workspace\\uploads";
        ArrayList<String> arr = new ArrayList<>();
        for(MultipartFile multipartFile : uploads) {
//            파일 이름 중복 피하기 위해 이름 수정
            UUID uuid =  UUID.randomUUID();
            String uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
            File saveFile = new File(uploadFolder, uploadFileName);
            try {
                multipartFile.transferTo(saveFile);
                arr.add(multipartFile.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("fileArr", arr);
        return "/file/fileResult";
    }

//    파일 게시판 추가 폼
    @GetMapping("fileBoardInsert")
    public void getFileBoardInsert(Model model) {}

//    파일 게시판 추가
    @PostMapping("fileBoardInsert")
    public void postFileBoardInsert(
            @ModelAttribute FileBoardDTO fileBoard,
            HttpServletRequest request
    ) {
//        파일 저장
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + "resources/images/";
        MultipartFile multipartFile = fileBoard.getUpload();
        String fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
        File saveFile = new File(uploadPath, fileName);
        try {
            multipartFile.transferTo(saveFile);
            fileBoard.setFileImage(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        DB 저장
        fileService.fileInsert(fileBoard);
    }
}
