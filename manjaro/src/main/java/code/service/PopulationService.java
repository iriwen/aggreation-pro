package code.service;



import code.entity.PopuBase;

import java.util.List;

/**
 * created by iriwen on 2020/04/02.
 */
public interface PopulationService {

    List<PopuBase> getPopulationList();

    List<PopuBase> queryPopulationByTag();

    List<PopuBase> getPopulationListByPage(int pageNum,int pageSize);

    //Object getTagsById();
}

