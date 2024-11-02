package com.itheima.service;

import com.itheima.pojo.Employee;
import com.itheima.pojo.EmployeeQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageBean;

public interface EmployeeService {

    /**
     * 登录
     */
    LoginInfo login(Employee employee);

    /**
     * 新增员工
     */
    void save(Employee employee);

    /**
     * 分页查询
     */
    PageBean page(EmployeeQueryParam queryParam);

    /**
     * 启用/禁用员工
     */
    void enableOrDisable(Integer status, Integer id);

    /**
     * 根据ID查询员工信息
     */
    Employee getById(Integer id);

    /**
     * 更新员工信息
     */
    void update(Employee employee);

    /**
     * 根据ID删除员工信息
     */
    void delById(Integer id);
}
