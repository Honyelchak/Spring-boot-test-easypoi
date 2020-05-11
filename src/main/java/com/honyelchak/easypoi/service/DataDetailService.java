package com.honyelchak.easypoi.service;

import com.honyelchak.easypoi.entity.DataDetail;
import java.util.List;

/**
 * (DataDetail)表服务接口
 *
 * @author yuejinzhao
 * @since 2020-05-11 18:31:42
 */
public interface DataDetailService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataDetail queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataDetail> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dataDetail 实例对象
     * @return 实例对象
     */
    DataDetail insert(DataDetail dataDetail);

    /**
     * 修改数据
     *
     * @param dataDetail 实例对象
     * @return 实例对象
     */
    DataDetail update(DataDetail dataDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}