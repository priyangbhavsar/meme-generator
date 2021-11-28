package com.memeGenerator.fun.service;

import java.io.FileOutputStream;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.memeGenerator.fun.common.Logger;
import com.memeGenerator.fun.configuration.MemeGeneratorConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private MemeGeneratorConfigurationProperties configurations;

    private String ROOT_FILE_PATH;

    private Path ROOT_LOCATION;

    @Override
    public void init() {
        this.ROOT_FILE_PATH = configurations.getUploadFilePath();
        this.ROOT_LOCATION = Paths.get(ROOT_FILE_PATH);
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new Exception("file is Empty ...");
            }
            Path destinationFilePath = this.ROOT_LOCATION.resolve(Paths.get(file.getOriginalFilename())).normalize()
                    .toAbsolutePath();
            FileOutputStream writer = new FileOutputStream(destinationFilePath.toAbsolutePath().toString());
            File destination = new File(destinationFilePath.toAbsolutePath().toString());
            if (!destination.exists()) {
                destination.createNewFile();
            }
            writer.write(file.getBytes());
        } catch (Exception e) {
            Logger.debugLog("file storage failed " + e);
        }

    }

    @Override
    public Resource loadAsResource(String filename) {
        Resource resource = null;
        try {
            Path file = this.ROOT_LOCATION.resolve(filename);
            Logger.debugLog("file " + file);
            resource = new UrlResource(file.toUri());
        } catch(Exception e) {
            Logger.debugLog("exception occured... " + e);
        }
        return resource;
    }
}
