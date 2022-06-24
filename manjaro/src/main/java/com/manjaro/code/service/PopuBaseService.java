package com.manjaro.code.service;

import com.manjaro.code.mapper.PopuBaseMapper;
import com.manjaro.json.entity.PopuBase;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PopuBaseService{

    @Resource
    private PopuBaseMapper popuBaseMapper;

    public int insert(PopuBase pojo){
        return popuBaseMapper.insert(pojo);
    }

    public int insertSelective(PopuBase pojo){
        return popuBaseMapper.insertSelective(pojo);
    }

    public int insertList(List<PopuBase> pojos){
        return popuBaseMapper.insertList(pojos);
    }

    public int update(PopuBase pojo){
        return popuBaseMapper.update(pojo);
    }
}
