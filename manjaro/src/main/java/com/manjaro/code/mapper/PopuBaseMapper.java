package com.manjaro.code.mapper;


import com.manjaro.json.entity.PopuBase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PopuBaseMapper {
    int insert(@Param("pojo") PopuBase pojo);

    int insertSelective(@Param("pojo") PopuBase pojo);

    int insertList(@Param("pojos") List<PopuBase> pojo);

    int update(@Param("pojo") PopuBase pojo);
}
