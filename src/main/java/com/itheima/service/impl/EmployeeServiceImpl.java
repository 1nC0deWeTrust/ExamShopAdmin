package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmployeeMapper;
import com.itheima.pojo.Employee;
import com.itheima.pojo.EmployeeQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmployeeService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public LoginInfo login(Employee employee) {
        //1. 调用mapper方法查询数据库
        Employee e = employeeMapper.selectByUsernameAndPass(employee);

        //2. 判断
        if (e != null) { //登录成功 - 生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());

            String jwt = JwtUtils.generateJwt(claims);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }
        return null;
    }

    @Override
    public void save(Employee employee) {
        //1. 补全实体属性
        employee.setStatus(1); //启用
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        //2. 调用mapper, 保存数据
        employeeMapper.insert(employee);
    }


    @Override
    public PageBean page(EmployeeQueryParam queryParam) {
        //1. 设置分页参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());

        //2. 执行查询
        List<Employee> employeeList = employeeMapper.list(queryParam);

        //3. 解析并封装结果
        Page<Employee> page = (Page<Employee>) employeeList;
        return new PageBean(page.getTotal(), page.getResult());
    }


    @Override
    public void enableOrDisable(Integer status, Integer id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setStatus(status);
        employeeMapper.update(employee);
    }


    @Override
    public Employee getById(Integer id) {
        return employeeMapper.getById(id);
    }

    @Override
    public void update(Employee employee) {
        //实体属性拷贝
        employee.setUpdateTime(LocalDateTime.now());
        employeeMapper.update(employee);
    }


    @Override
    public void delById(Integer id) {
        employeeMapper.deleteById(id);
    }
}
