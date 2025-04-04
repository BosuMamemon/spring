package com.example.simpleboard.service;

import com.example.simpleboard.dto.FileBoardDTO;

import java.util.List;

public interface FileRepository {
    void fileInsert(FileBoardDTO fileBoard);
    List<FileBoardDTO> fileList();
}
