package com.honyelchak.easypoi.controller;

import com.honyelchak.easypoi.entity.DataDetail;
import com.honyelchak.easypoi.service.DataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DataDetail)表控制层
 *
 * @author honyelchak
 * @since 2020-05-11 18:31:43
 */

@RestController
@RequestMapping
public class DataDetailController {
    /**
     * 服务对象
     */
    @Autowired
    @Qualifier("dataDetailService")
    private DataDetailService dataDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DataDetail selectOne(Integer id) {
        return this.dataDetailService.queryById(id);
    }

}