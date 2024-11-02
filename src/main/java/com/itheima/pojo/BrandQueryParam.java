package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandQueryParam {

    private Integer page; //页码
    private Integer pageSize; //每页展示记录数
    private String name; //品牌名称
    private String firstLetter; //品牌首字母

}
