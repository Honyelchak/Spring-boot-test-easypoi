package com.honyelchak.easypoi.excel;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.honyelchak.easypoi.entity.DataDetail;
import com.honyelchak.easypoi.service.DataDetailService;
import com.honyelchak.easypoi.util.ExcelServiceUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Honyelchak
 * @ClassName: ExcelTest
 * @Description:
 * @create 2020-05-11
 */
@SpringBootTest
public class ExcelTest {


    @Autowired
    ExcelServiceUtil excelServiceUtil;

    @Autowired
    DataDetailService dataDetailService;

    String importFilePath = "D:/Users/Desktop/test.xls";
    String exportFilePath = "D:/Users/Desktop/test.xls";


    @Test
    public void exportTest() {
        List<DataDetail> dataDetails = dataDetailService.queryAllByLimit(0, 500);

        ExportParams exportParams = new ExportParams("小麦论文", "wheat");
        excelServiceUtil.exportExcel(exportParams, dataDetails, DataDetail.class, exportFilePath);
    }

    @Test
    public void importTest() {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        List<DataDetail> entitysFromExcel = excelServiceUtil.getEntitysFromExcel(importParams, DataDetail.class, importFilePath);

        entitysFromExcel.stream().limit(100).forEach((e) -> System.out.println(e.toString()));

    }

}
