package com.google.spring.service;



import com.google.spring.entity.PopuBase;

import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
public interface PopulationService {

    List<PopuBase> getPopulationList();

    List<PopuBase> queryPopulationByTag();

    List<PopuBase> getPopulationListByPage(int pageNum,int pageSize);

    //Object getTagsById();
}

