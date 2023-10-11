package com.imooc.bilibili.service;

import com.imooc.bilibili.dao.MallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MallService {
    @Autowired
    public MallDao mallDao;

    public Map<String, Object> query(Long id) {
        return mallDao.queryById(id);
    }
}
