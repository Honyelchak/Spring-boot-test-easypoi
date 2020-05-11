package com.honyelchak.easypoi.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.honyelchak.easypoi.constants.ExcelConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExcelImportService
 * @Description: 导入Excel
 * @Author: JonnyYue
 * @date: 2020/5/11
 */
@Slf4j
@Service
public class ExcelServiceUtil {

    /**
     * @Description:从Excel中获取数据，返回List<Map>
     * @Param:importParams 导入参数， filePath 文件绝对路径
     * @return: List<Map>
     * @Author: Honyelchak
     * @date: 2020/5/11
     */
    public List<Map<String, Object>> getMapFromExcel(ImportParams importParams, String filePath) {

        File file = getFileByFilePath(filePath, ExcelConstants.CODE_IMPORT.getCode());

        Instant start = Instant.now();

        List<Map<String, Object>> objects = ExcelImportUtil.importExcel(file, Map.class, importParams);

        Instant end = Instant.now();

        long l = Duration.between(start, end).toMillis();

        log.info("耗时：{}", l);
        return objects;
    }

    public <T> List<T> getEntitysFromExcel(ImportParams importParams, Class<T> t, String filePath) {

        File file = getFileByFilePath(filePath, ExcelConstants.CODE_IMPORT.getCode());

        Instant start = Instant.now();
        List<T> objects = ExcelImportUtil.importExcel(file, t, importParams);
        Instant end = Instant.now();

        long l = Duration.between(start, end).toMillis();

        log.info("耗时：{}", l);
        return objects;
    }


    public void exportExcel(ExportParams exportParams, List<?> list, Class t, String filePath) {

        try {
            Workbook sheets = ExcelExportUtil.exportExcel(exportParams, t, list);

            File file = getFileByFilePath(filePath, ExcelConstants.CODE_EXPORT.getCode());

            FileOutputStream fileOutputStream = new FileOutputStream(file);

            sheets.write(fileOutputStream);

            fileOutputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: 通过文件路径获取File对象
     * @Param: filePath 文件绝对路径
     * @return: File
     * @Author: Honyelchak
     * @date: 2020/5/11
     */
    private File getFileByFilePath(String filePath, Character moduleCode) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            log.info("{} 不是一个正确的文件绝对路径", filePath);
            return null;
        }

        if (!file.exists()) {
            if (ExcelConstants.CODE_IMPORT.equals(moduleCode)) {
                log.info("{} 文件不存在", filePath);
                return null;
            } else {
                try {
                    boolean flag = file.createNewFile();
                    if (flag) {
                        return file;
                    } else {
                        log.info("文件生成失败! {}", filePath);
                        return null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        return file;
    }
}
