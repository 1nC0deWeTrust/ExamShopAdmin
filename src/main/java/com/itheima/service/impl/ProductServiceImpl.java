package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.BusinessException;
import com.itheima.mapper.ProductMapper;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void save(Product product) {
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());

        product.setPublishStatus(0);//默认下架
        product.setVerifyStatus(0);//未审核

        productMapper.insert(product);
    }

    @Override
    public void updateById(Product product) {
        product.setUpdateTime(LocalDateTime.now());
        productMapper.update(product);
    }

    @Override
    public void delete(Integer id) {
        //1. 查询商品的状态
        Product product = productMapper.getById(id);
        if (product.getPublishStatus().equals(1)) {
            throw new BusinessException("上架中的商品不能删除");
        }

        //2. 删除商品
        productMapper.deleteById(id);
    }

    @Override
    public Product getById(Integer id) {
        return productMapper.getById(id);
    }

    @Override
    public void upOrDown(Integer id, Integer publishStatus) {
        Product product = new Product();
        product.setId(id);
        product.setPublishStatus(publishStatus);
        product.setUpdateTime(LocalDateTime.now());
        productMapper.update(product);
    }


    @Override
    public void verify(Integer id, Integer status) {
        Product product = new Product();
        product.setId(id);
        product.setVerifyStatus(status);
        product.setUpdateTime(LocalDateTime.now());
        productMapper.update(product);
    }

    @Override
    public PageBean<Product> getList(String name, Integer brandId, Integer publishStatus, Integer verifyStatus,
                                     Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        Page<Product> pageResult = productMapper.selectList(name, brandId, publishStatus, verifyStatus);

        PageBean<Product> result = new PageBean<>();
        result.setTotal(pageResult.getTotal());
        result.setRows(pageResult);

        return result;
    }
}
