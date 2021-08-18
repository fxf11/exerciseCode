package com.fxf.file_up_down.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @Description TODO 操作上传文件的接口类
 * @Author Administrator
 * @Date 2021/8/18 9:08
 * @Version 1.0
 */
public interface FileStorageService {

    void init();

    void save(MultipartFile multipartFile);

    Resource load(String filename);

    Stream<Path> load();

    void clear();

}
