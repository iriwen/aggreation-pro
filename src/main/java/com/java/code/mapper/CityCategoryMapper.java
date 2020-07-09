package com.java.code.mapper;

import com.java.code.entity.CityCategory;
import com.java.code.entity.PopuBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
@Mapper
public interface CityCategoryMapper {

    List<CityCategory> getCategory();

    List<PopuBase> findCityByParentid(int parentId);
}
