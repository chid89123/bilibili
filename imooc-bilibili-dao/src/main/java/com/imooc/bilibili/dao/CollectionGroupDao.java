package com.imooc.bilibili.dao;

import com.imooc.bilibili.domain.CollectionGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionGroupDao {
    Integer addVideoCollectionGroup(CollectionGroup collectionGroup);

    List<CollectionGroup> getVideoCollectionGroup(Long userId);
}
