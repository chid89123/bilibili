package com.imooc.bilibili.dao;

import com.imooc.bilibili.domain.UserMoment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMomentsDao {

    void addUserMoments(UserMoment userMoment);

}
