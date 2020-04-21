package com.google.spring.service.impl;


import com.google.spring.entity.PopuBase;
import com.google.spring.mapper.PopulationMapper;
import com.google.spring.service.PopulationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
@Service("populationService")
public class PopulationServiceImpl implements PopulationService {


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
            int offset = (pageNum-1) * pageSize ;
            return populationMapper.getPopulationListByPage(offset, pageSize);
        }
    }
}