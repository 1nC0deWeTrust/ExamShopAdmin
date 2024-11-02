package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping("productUpOrDown")
    public Result getProductUpOrDown() {
        return Result.success(reportService.getProductUpOrDown());
    }

    @GetMapping("productStatus")
    public Result getProductStatus() {
        return Result.success(reportService.getProductStatus());
    }
}
