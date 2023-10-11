package com.imooc.bilibili.service;

import com.imooc.bilibili.dao.CollectionGroupDao;
import com.imooc.bilibili.domain.CollectionGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectionGroupService {
    @Autowired
    private CollectionGroupDao collectionGroupDao;

    public Long addVideoCollectionGroup(CollectionGroup collectionGroup) {
        collectionGroup.setCreateTime(new Date());
        collectionGroupDao.addVideoCollectionGroup(collectionGroup);
        return collectionGroup.getId();
    }

    public List<CollectionGroup> getVideoCollectionGroup(Long userId) {
        return collectionGroupDao.getVideoCollectionGroup(userId);
    }
}
