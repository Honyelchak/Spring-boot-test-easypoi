package com.honyelchak.easypoi.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
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
public class ExcelImportService {

    /**
     * @Description:从Excel中获取数据，返回List<Map>
     * @Param:importParams 导入参数， filePath 文件绝对路径
     * @return: List<Map>
     * @Author: Honyelchak
     * @date: 2020/5/11
     */
    public List<Map> getMapFromExcel(ImportParams importParams, String filePath) {

        File file = getFileByFilePath(filePath);

        Instant start = Instant.now();

        List<Map> objects = ExcelImportUtil.importExcel(file, Map.class, importParams);

        Instant end = Instant.now();

        long l = Duration.between(start, end).toMillis();

        log.info("耗时：{}", l);
        return objects;
    }


    /**
     * @Description: 通过文件路径获取File对象
     * @Param: filePath 文件绝对路径
     * @return: File
     * @Author: Honyelchak
     * @date: 2020/5/11
     */
    private File getFileByFilePath(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {
            log.info("{} 不是一个正确的文件绝对路径", filePath);
            return null;
        }
        if (!file.exists()) {
            log.info("{} 文件不存在", filePath);
            return null;
        }
        return file;
    }
}
