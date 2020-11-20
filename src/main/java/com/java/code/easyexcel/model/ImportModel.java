package com.java.code.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * created by yuxiaodong01 on 2020/11/19.
 */

@Data
public class ImportModel {

    @ExcelProperty(index = 0)
    private String mobile;

   /* @ExcelProperty(index = 1)
    private String author;

    @ExcelProperty(index = 2)
    private String book;*/

}