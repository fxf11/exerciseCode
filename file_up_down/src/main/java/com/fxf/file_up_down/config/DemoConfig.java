package com.fxf.file_up_down.config;

import com.fxf.file_up_down.service.impl.FileStorageServiceImpl;
import com.fxf.file_up_down.valueobject.Message;
import com.fxf.file_up_down.valueobject.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/8/24 22:15
 */
@Configuration
@EnableConfigurationProperties({UploadFile.class})
@ConditionalOnProperty(prefix = "uploadFile",name = "isopen",havingValue = "true")
public class DemoConfig {

    @Autowired
    private UploadFile uploadFile;

//    @Bean(name = "demo")
//    public FileStorageServiceImpl fileStorageServiceImpl(){
//        return new FileStorageServiceImpl()
//    }
}
