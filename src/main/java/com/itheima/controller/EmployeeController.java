package com.itheima.controller;

import com.itheima.pojo.Employee;
import com.itheima.pojo.EmployeeQueryParam;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 员工管理
 */
@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Employee employee) {
        log.info("新增员工, {}", employee);
        employeeService.save(employee);
        return Result.success();
    }


    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmployeeQueryParam queryParam) {
        log.info("条件分页查询, {}", queryParam);
        PageBean pageBean = employeeService.page(queryParam);
        return Result.success(pageBean);
    }


    /**
     * 启用/禁用员工
     */
    @PutMapping("/status/{status}/{id}")
    public Result enableOrDisable(@PathVariable Integer status, @PathVariable Integer id) {
        log.info("启用/禁用员工 , {}, {}", status, id);
        employeeService.enableOrDisable(status, id);
        return Result.success();
    }


    /**
     * 根据ID查询员工信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询员工信息, id:{}", id);
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    /**
     * 编辑员工信息
     */
    @PutMapping
    public Result update(@RequestBody Employee employee) {
        log.info("编辑员工: {}", employee);
        employeeService.update(employee);
        return Result.success();
    }


    /**
     * 根据ID删除员工信息
     */
    @DeleteMapping("/{id}")
    public Result delById(@PathVariable Integer id) {
        log.info("根据ID删除员工信息, id:{}", id);
        employeeService.delById(id);
        return Result.success();
    }


}
