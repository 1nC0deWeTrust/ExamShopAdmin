package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    /**
     * 新增商品
     */
    void insert(Product product);

    /**
     * 更新商品
     */
    void update(Product product);

    /**
     * 根据ID查询商品
     */
    Product getById(Integer id);

    /**
     * 根据ID删除商品
     */
    void deleteById(Integer id);

    Page<Product> selectList(String name, Integer brandId, Integer publishStatus, Integer verifyStatus);
}
