package com.fxf.file_up_down.controller;

import com.fxf.file_up_down.service.FileStorageService;
import com.fxf.file_up_down.valueobject.Message;
import com.fxf.file_up_down.valueobject.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.lang.module.ResolutionException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/18 10:03
 * @Version 1.0
 */
@RestController
public class FileUploadController {

    @Autowired
    @SuppressWarnings("all")
    FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<Message> upload(@RequestParam("file") MultipartFile file){
        try {
            fileStorageService.save(file);
            return ResponseEntity.ok(new Message("Upload file successfully: "+file.getOriginalFilename()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new Message("Could not upload the file:"+file.getOriginalFilename()));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<UploadFile>> files(){
        Stream<Path> load = fileStorageService.load();
        List<UploadFile> files = load
                .map(path -> {
                    String fileName = path.getFileName().toString();
                    String url = MvcUriComponentsBuilder
                            .fromMethodName(FileUploadController.class,
                                    "getFile",
                                    path.getFileName().toString()
                            ).build().toString();
                    return new UploadFile(fileName,url);
                }).collect(Collectors.toList());
        return ResponseEntity.ok(files);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable("filename")String filename){
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=\""+file.getFilename()+"\"")
                .body(file);
    }




}
