package com.example.simpleboard.service;

import com.example.simpleboard.dto.FileBoardDTO;
import com.example.simpleboard.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {
    private final FileMapper fileMapper;

    @Override
    public void fileInsert(FileBoardDTO fileBoard) {
        fileMapper.fileInsert(fileBoard);
    }

    @Override
    public List<FileBoardDTO> fileList() {
        return List.of();
    }
}
