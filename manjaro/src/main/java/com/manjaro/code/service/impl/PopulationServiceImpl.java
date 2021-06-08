package com.manjaro.code.service.impl;


import com.manjaro.cache.CacheDurationConfig;
import com.manjaro.code.mapper.PopuBaseMapper;
import com.manjaro.code.service.PopulationService;
import com.manjaro.json.entity.PopuBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * created by iriwen on 2020/04/02.
 */
@Service("populationService")
public class PopulationServiceImpl implements PopulationService {

    private final Logger logger = LoggerFactory.getLogger(PopulationServiceImpl.class);

    //@Resource
    //private PopulationMapper populationMapper;

    @Autowired
    private PopuBaseMapper populationMapper;

    @Override
    @Cacheable(cacheNames = CacheDurationConfig.DAY_7,key = "#root.method")
    public List<PopuBase> getPopulationList() {
        return populationMapper.getPopulationList();
    }

    @Override
    public List<PopuBase> queryPopulationByTag() {
        return populationMapper.queryPopulationByTag();
    }

    @Override
    public List<PopuBase> getPopulationListByPage(int pageNum, int pageSize) {

        if (pageNum <= 0) {
            return Collections.emptyList();
        } else {
            int offset = (pageNum - 1) * pageSize;
            return populationMapper.getPopulationListByPage(offset, pageSize);
        }
    }
    //spring 注解执行初始化构造方法
    @PostConstruct
    public void testPost() {
        logger.info(System.currentTimeMillis() + ": PopulationServiceImpl-->testPost()");
    }
}