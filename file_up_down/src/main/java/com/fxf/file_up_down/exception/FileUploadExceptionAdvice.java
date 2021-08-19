package com.fxf.file_up_down.exception;

import com.fxf.file_up_down.valueobject.Message;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.module.ResolutionException;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/18 10:10
 * @Version 1.0
 */
@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public ResponseEntity<Message> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e){
        return ResponseEntity.badRequest().body(new Message("Upload file too large."));
    }
}
