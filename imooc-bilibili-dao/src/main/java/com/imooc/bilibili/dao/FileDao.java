package com.imooc.bilibili.dao;

import org.apache.ibatis.annotations.Mapper;

import com.imooc.bilibili.domain.File;

@Mapper
public interface FileDao {


    Integer addFile(File file);
    File getFileByMd5(String md5);
}
