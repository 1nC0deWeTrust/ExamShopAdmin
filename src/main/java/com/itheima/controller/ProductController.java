package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;
import com.itheima.pojo.Result;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品管理
 */
@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * name string 否 商品名称
     * brandId integer 否 品牌ID
     * publishStatus integer 否 上下架状态 , 0: 下架 , 1: 上架
     * verifyStatus integer 否  审核状态, 0: 未审核, 1: 审核通过, 2: 审核未通过
     * page integer 是 页码
     * pageSize integer 是 每页展示记录数
     */
    @GetMapping
    public Result getList(@RequestParam(required = false) String name,
                          @RequestParam(required = false) Integer brandId,
                          @RequestParam(required = false) Integer publishStatus,
                          @RequestParam(required = false) Integer verifyStatus,
                          @RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean<Product> result = productService.getList(name, brandId, publishStatus, verifyStatus, page, pageSize);
        return Result.success(result);
    }

    /**
     * 保存商品
     */
    @PostMapping
    public Result save(@RequestBody Product product) {
        productService.save(product);
        return Result.success();
    }

    /**
     * 更新商品
     */
    @PutMapping
    public Result updateById(@RequestBody Product product) {
        productService.updateById(product);
        return Result.success();
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/{id}")
    public Result removeById(@PathVariable Integer id) {
        productService.delete(id);
        return Result.success();
    }

    /**
     * 根据ID查询商品
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return Result.success(product);
    }

    /**
     * 上下架
     */
    @PutMapping("/publish/{id}/{publishStatus}")
    public Result upOrDown(@PathVariable Integer id, @PathVariable Integer publishStatus) {
        productService.upOrDown(id, publishStatus);
        return Result.success();
    }


    /**
     * 审核
     */
    @PutMapping("/verify/{id}/{status}")
    public Result verify(@PathVariable Integer id, @PathVariable Integer status) {
        productService.verify(id, status);
        return Result.success();
    }

}
