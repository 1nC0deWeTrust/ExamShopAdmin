package com.itheima.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {
    @MapKey("name")
    List<Map<String, Object>> getProductStatus();

    @MapKey("name")
    List<Map<String, Object>> getProductUpOrDown();
}
