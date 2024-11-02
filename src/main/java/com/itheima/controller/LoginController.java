package com.itheima.controller;

import com.itheima.pojo.Employee;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee) {
        log.info("员工进行登录了..... ");
        LoginInfo loginInfo = employeeService.login(employee);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误!");
    }


    /**
     * 空请求[不用管, 也不要动]
     */
    @GetMapping("/index")
    public Result index() {
        return Result.success();
    }

}
