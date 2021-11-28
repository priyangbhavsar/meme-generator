package com.memeGenerator.fun.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init();

    void store(MultipartFile file);

    Resource loadAsResource(String filename);
}
