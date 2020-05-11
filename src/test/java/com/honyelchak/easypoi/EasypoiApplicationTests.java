package com.honyelchak.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.honyelchak.easypoi.service.ExcelImportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class EasypoiApplicationTests {


    @Autowired
    ExcelImportService excelImportService;

    String filePath = "D:/Users/Desktop/2019-2020-1课程课表.xls";

    @Test
    void contextLoads() {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(3);
        importParams.setHeadRows(1);
        List<Map> maps = excelImportService.getMapFromExcel(importParams, filePath);
        System.out.println(maps);
    }

}
