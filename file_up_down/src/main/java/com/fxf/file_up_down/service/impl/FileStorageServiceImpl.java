package com.fxf.file_up_down.service.impl;

import com.fxf.file_up_down.service.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2021/8/18 9:12
 * @Version 1.0
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path path = Paths.get("E:/");

    @Override
    public void init() {
        try {
            //通过创建所有不存在的父目录来创建目录。
            Files.createDirectories(path);
        }catch (IOException e){
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile multipartFile) {
        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path resolve = this.path.resolve(multipartFile.getOriginalFilename());
            Files.copy(inputStream,resolve);
        }catch (IOException e){
            throw new RuntimeException("Could not store the file. Error:"+e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {

        Path file = path.resolve(filename);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("Could not read the file.");
            }

        }catch (MalformedURLException e){
            throw new RuntimeException("Error:"+e.getMessage());
        }
    }

    @Override
    public Stream<Path> load() {
        try {
            Stream<Path> walk = Files.walk(this.path, 1);
            Stream<Path> pathStream = walk.filter(path1 -> !path.equals(this.path));
            Stream<Path> pathStream1 = pathStream.map(this.path::relativize);

            return Files.walk(this.path,1).filter(path1 -> !path.equals(this.path)).map(this.path::relativize);
        }catch (IOException e){
            throw new RuntimeException("Could not load the files.");
        }
    }

    @Override
    public void clear() {
        FileSystemUtils.deleteRecursively(path.toFile());
    }
}
