package com.google.spring.controller;


import com.google.spring.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
@RestController
@RequestMapping(value = "/population")
public class PopulationController {

    @Autowired
    private PopulationService populationService;

    @RequestMapping(value = "/listByPage/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUserByPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return populationService.getPopulationListByPage(pageNum, pageSize);
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser() {
        return populationService.getPopulationList();
    }


    @RequestMapping(value = "/tags/{id}", produces = {"application/json;charset=UTF-8"})
    public Object getTagsById(@PathVariable("id") String id) {
        //return populationService.getTagsById();
        return null;
    }

}

