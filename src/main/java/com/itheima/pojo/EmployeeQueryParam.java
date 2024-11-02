package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeQueryParam {

    private Integer page; //页码
    private Integer pageSize; //每页展示记录数
    private String name; //姓名
    private String email; //邮箱
    private String username; //用户名

}
