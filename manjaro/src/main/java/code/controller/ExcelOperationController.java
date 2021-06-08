package code.controller;

import code.easyexcel.model.ExportModel;
import code.easyexcel.model.ImportModel;
import code.easyexcel.util.ExcelUtil;
import code.util.JsonMapper;
import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * created by iriwen on 2020/11/19.
 */

@RestController
@RequestMapping(value = "/easyExcel")
public class ExcelOperationController {

    private final Logger logger = LoggerFactory.getLogger(ExcelOperationController.class);

    @PostMapping(value = "/import")
    public List<ImportModel> read(@RequestParam("file") MultipartFile excel) {
        Objects.requireNonNull(excel);
        List<ImportModel> importModels = ExcelUtil.readExcel(excel, ImportModel.class, 0);
        logger.info("data info : {}",importModels.size()+"; 操作的线程信息 ：" + Thread.currentThread().getName());
        return importModels;
    }

    @GetMapping(value = "/parseLocalExcel")
    public List<ImportModel> read() {

        String filePath = "/home/worker/文档/导入的模板文件.xlsx";
        List<ImportModel> importModels = EasyExcel.read(filePath).head(ImportModel.class).sheet().doReadSync();

        logger.info("parse result : {}", JsonMapper.toJsonString(importModels));
        return importModels;
    }

    @GetMapping(value = "/export")
    public void writeExcel(HttpServletResponse response) {
        List<ExportModel> list = getList();
        String fileName = "Excel导出测试";
        String sheetName = "sheet1";
        ExcelUtil.writeDynamicHeadExcel(response, list, fileName, sheetName, ExportModel.class, head());
    }

    private List<ExportModel> getList() {
        List<ExportModel> modelList = new ArrayList<>();

        ExportModel firstModel = new ExportModel();
        firstModel.setName("李明");
        firstModel.setSex("男");
        firstModel.setAge(20);
        modelList.add(firstModel);

        ExportModel secondModel = new ExportModel();
        secondModel.setName("珍妮");
        secondModel.setSex("女");
        secondModel.setAge(19);
        modelList.add(secondModel);

        return modelList;
    }

    private List<List<String>> head() {

        List<List<String>> headList = new ArrayList<>();
        List<String> nameHead = new ArrayList<>();
        nameHead.add("姓名");
        List<String> genderHead = new ArrayList<>();
        genderHead.add("性别");
        List<String> ageHead = new ArrayList<>();
        ageHead.add("年龄");
        headList.add(nameHead);
        headList.add(genderHead);
        headList.add(ageHead);

        return headList;
    }
}
