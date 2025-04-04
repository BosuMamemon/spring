package com.example.simpleboard.service;

import com.example.simpleboard.dto.FileBoardDTO;

import java.util.List;

public interface FileService {
    void fileInsert(FileBoardDTO fileBoard);
    List<FileBoardDTO> fileList();
}
