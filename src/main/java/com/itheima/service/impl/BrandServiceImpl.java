package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.BrandQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void save(Brand brand) {
        brand.setCreateTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insert(brand);
    }

    @Override
    public void updateById(Brand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.update(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandMapper.deleteById(id);
    }

    @Override
    public Brand getById(Integer id) {
        return brandMapper.getById(id);
    }

    @Override
    public PageBean page(BrandQueryParam queryParam) {
        //1. 设置请求参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());

        //2. 执行查询
        List<Brand> categoryList = brandMapper.list(queryParam);
        Page<Brand> page = (Page<Brand>) categoryList;

        //3. 封装结果
        return new PageBean(page.getTotal(), page.getResult());
    }


    @Override
    public List<Brand> findAll() {
        return brandMapper.list(new BrandQueryParam());
    }
}
