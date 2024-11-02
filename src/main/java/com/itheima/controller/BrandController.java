package com.itheima.controller;

import com.itheima.pojo.Brand;
import com.itheima.pojo.BrandQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理
 */
@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 新增品牌
     */
    @PostMapping
    public Result save(@RequestBody Brand brand) {
        brandService.save(brand);
        return Result.success();
    }

    /**
     * 根据ID更新品牌
     */
    @PutMapping
    public Result updateById(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return Result.success();
    }

    /**
     * 根据ID删除品牌
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        brandService.deleteById(id);
        return Result.success();
    }

    /**
     * 根据ID查询品牌
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Brand brand = brandService.getById(id);
        return Result.success(brand);
    }

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(BrandQueryParam queryParam) {
        PageBean pageBean = brandService.page(queryParam);
        return Result.success(pageBean);
    }

    /**
     * 查询全部
     */
    @GetMapping("/list")
    public Result findAll() {
        List<Brand> brandList = brandService.findAll();
        return Result.success(brandList);
    }
}
