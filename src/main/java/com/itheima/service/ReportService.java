package com.itheima.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    List<Map<String, Object>> getProductUpOrDown();

    List<Map<String, Object>> getProductStatus();

}
