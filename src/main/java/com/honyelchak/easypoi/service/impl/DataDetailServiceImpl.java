package com.honyelchak.easypoi.service.impl;

import com.honyelchak.easypoi.entity.DataDetail;
import com.honyelchak.easypoi.dao.DataDetailDao;
import com.honyelchak.easypoi.service.DataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DataDetail)表服务实现类
 *
 * @author makejava
 * @since 2020-05-11 18:31:42
 */
@Service("dataDetailService")
public class DataDetailServiceImpl implements DataDetailService {

    @Autowired
    @Qualifier("dataDetailDao")
    private DataDetailDao dataDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DataDetail queryById(Integer id) {
        return this.dataDetailDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DataDetail> queryAllByLimit(int offset, int limit) {
        return this.dataDetailDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dataDetail 实例对象
     * @return 实例对象
     */
    @Override
    public DataDetail insert(DataDetail dataDetail) {
        this.dataDetailDao.insert(dataDetail);
        return dataDetail;
    }

    /**
     * 修改数据
     *
     * @param dataDetail 实例对象
     * @return 实例对象
     */
    @Override
    public DataDetail update(DataDetail dataDetail) {
        this.dataDetailDao.update(dataDetail);
        return this.queryById(dataDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dataDetailDao.deleteById(id) > 0;
    }
}