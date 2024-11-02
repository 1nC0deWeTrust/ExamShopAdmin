package com.itheima.mapper;

import com.itheima.pojo.Brand;
import com.itheima.pojo.BrandQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    /**
     * 根据ID查询品牌
     */
    Brand getById(Integer id);

    /**
     * 插入品牌
     */
    void insert(Brand brand);

    /**
     * 更新品牌
     */
    void update(Brand brand);

    /**
     * 删除品牌
     */
    void deleteById(Integer id);

    /**
     * 条件查询
     */
    List<Brand> list(BrandQueryParam queryParam);
}
