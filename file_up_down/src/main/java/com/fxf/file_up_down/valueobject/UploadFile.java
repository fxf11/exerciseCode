package com.fxf.file_up_down.valueobject;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/18 9:58
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "uploadFile")
public class UploadFile {

    private String fileName;
    private String url;

    public UploadFile(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
