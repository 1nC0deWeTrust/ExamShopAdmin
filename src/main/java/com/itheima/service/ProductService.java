package com.itheima.service;


import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;

public interface ProductService {

    /**
     * 保存商品
     */
    void save(Product product);

    /**
     * 更新商品
     */
    void updateById(Product product);

    /**
     * 删除商品
     */
    void delete(Integer id);

    /**
     * 根据ID查询商品
     */
    Product getById(Integer id);

    /**
     * 上下架商品
     */
    void upOrDown(Integer id, Integer publishStatus);

    /**
     * 商品审核
     */
    void verify(Integer id, Integer status);

    PageBean<Product> getList(String name, Integer brandId, Integer publishStatus, Integer verifyStatus, Integer page, Integer pageSize);
}
