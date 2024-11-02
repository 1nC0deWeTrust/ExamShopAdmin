package com.itheima.service;


import com.itheima.pojo.Brand;
import com.itheima.pojo.BrandQueryParam;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 新增品牌
     */
    void save(Brand brand);

    /**
     * 根据ID更新品牌
     */
    void updateById(Brand brand);

    /**
     * 根据ID删除品牌
     */
    void deleteById(Integer id);

    /**
     * 根据ID查询品牌
     */
    Brand getById(Integer id);

    /**
     * 分页查询
     */
    PageBean page(BrandQueryParam queryParam);

    /**
     * 查询全部
     */
    List<Brand> findAll();
}
