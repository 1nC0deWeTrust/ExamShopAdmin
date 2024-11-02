package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 文件上传的Controller
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 阿里云OSS
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传 , 上传的文件名: {}", file.getOriginalFilename());
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = aliOssUtil.upload(file.getBytes(), UUID.randomUUID() + extName);
        return Result.success(url);
    }

}
