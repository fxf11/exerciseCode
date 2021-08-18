package com.fxf.file_up_down.config;

import com.fxf.file_up_down.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @Description TODO 初始化文件存储空间，实现CommandLineRunner后，在程序启动的时候会调用run方法
 * @Author Administrator
 * @Date 2021/8/18 10:14
 * @Version 1.0
 */
public class FileUploadConfiguration implements CommandLineRunner {

    @Autowired
    FileStorageService fileStorageService;

    @Override
    public void run(String... args) throws Exception {
        fileStorageService.clear();
        fileStorageService.init();

    }
}
