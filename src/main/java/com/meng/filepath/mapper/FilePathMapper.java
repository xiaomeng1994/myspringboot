package com.meng.filepath.mapper;

import com.meng.filepath.vo.FilePathVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FilePathMapper {

    void insertFilePath(FilePathVO filePathVO);

}
