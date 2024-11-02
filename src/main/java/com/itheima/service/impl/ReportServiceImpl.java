package com.itheima.service.impl;

import com.itheima.mapper.ReportMapper;
import com.itheima.service.ReportService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<Map<String, Object>> getProductUpOrDown() {
        return reportMapper.getProductUpOrDown();
    }

    @Override
    public List<Map<String, Object>> getProductStatus() {
        return reportMapper.getProductStatus();
    }
}
