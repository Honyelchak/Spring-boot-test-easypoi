package com.honyelchak.easypoi.dao;

import com.honyelchak.easypoi.entity.DataDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (DataDetail)表数据库访问层
 *
 * @author yuejinzhao
 * @since 2020-05-11 18:31:41
 */
@Repository("dataDetailDao")
public interface DataDetailDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataDetail queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataDetail> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dataDetail 实例对象
     * @return 对象列表
     */
    List<DataDetail> queryAll(DataDetail dataDetail);

    /**
     * 新增数据
     *
     * @param dataDetail 实例对象
     * @return 影响行数
     */
    int insert(DataDetail dataDetail);

    /**
     * 修改数据
     *
     * @param dataDetail 实例对象
     * @return 影响行数
     */
    int update(DataDetail dataDetail);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}