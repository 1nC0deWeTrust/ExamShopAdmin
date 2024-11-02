package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 商品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id; //主键ID
    private Integer brandId; //品牌ID
    private String name; //商品名称
    private String pic; //商品图片
    private Integer publishStatus; //上架状态：0->下架；1->上架
    private Integer verifyStatus; //审核状态：0->未审核；1->审核通过 ; 2->审核未通过
    private Integer price; //价格 (单位: 分)
    private String description; //商品描述
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间


    private String brandName; //部门名称

}
