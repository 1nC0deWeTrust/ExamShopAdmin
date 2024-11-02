package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 员工
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;  //主键ID
    private String username; //用户名
    private String name; //真实姓名
    private String password; //密码
    private String email; //邮箱
    private String note; //备注信息
    private Integer status; //帐号启用状态：0->禁用；1->启用
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间

}
