package com.example.simpleboard.mapper;

import com.example.simpleboard.dto.FileBoardDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {
    @Insert("INSERT INTO fileboard(title, writer, content, fileimage) " +
            "VALUES(#{title}, #{writer}, #{content}, #{fileImage})")
    void fileInsert(FileBoardDTO fileBoard);

    @Select("SELECT * FROM fileboard ORDER BY num DESC")
    List<FileBoardDTO> fileList();
}
