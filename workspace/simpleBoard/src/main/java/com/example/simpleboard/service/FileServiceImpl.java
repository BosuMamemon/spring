package com.example.simpleboard.service;

import com.example.simpleboard.dto.FileBoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;

    @Override
    public void fileInsert(FileBoardDTO fileBoard) {
        fileRepository.fileInsert(fileBoard);
    }

    @Override
    public List<FileBoardDTO> fileList() {
        return List.of();
    }
}
