package com.manjaro.code.mapper;


import com.manjaro.json.entity.PopuBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * created by iriwen on 2020/04/02.
 */
@Mapper
public interface PopulationMapper {

    List<PopuBase> queryPopulationByTag();

    List<PopuBase> getPopulationList();

    List<PopuBase> getPopulationListByPage(int offset, int pageSize);
}
