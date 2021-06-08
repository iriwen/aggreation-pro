package code.mapper;

import code.entity.CityCategory;
import code.entity.PopuBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * created by iriwen on 2020/04/02.
 */
@Mapper
public interface CityCategoryMapper {

    List<CityCategory> getCategory();

    List<PopuBase> findCityByParentid(int parentId);
}
