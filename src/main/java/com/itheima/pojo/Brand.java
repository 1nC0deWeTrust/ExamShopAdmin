package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 品牌
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Integer id; //主键ID
    private String name; //品牌名称
    private String firstLetter; //首字母
    private String logo; //品牌logo
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

}
