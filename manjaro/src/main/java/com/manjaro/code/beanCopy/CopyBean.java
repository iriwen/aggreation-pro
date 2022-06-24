package com.manjaro.code.beanCopy;

import org.springframework.beans.BeanUtils;

public class CopyBean {
    public static void main(String[] args) {

        SourceBean src = new SourceBean();

        DistBean dist = new DistBean();
        //src =null ;
        //BeanUtils.copyProperties(src,dist);

        System.out.println(""+ dist.getClass().getName());

    }
}
