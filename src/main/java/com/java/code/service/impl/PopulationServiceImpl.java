package com.java.code.service.impl;


import com.java.code.entity.PopuBase;
import com.java.code.mapper.PopulationMapper;
import com.java.code.service.PopulationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
@Service("populationService")
public class PopulationServiceImpl implements PopulationService {

    private final Logger logger = LoggerFactory.getLogger(PopulationServiceImpl.class);

    @Resource
    private PopulationMapper populationMapper;

    @Override
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