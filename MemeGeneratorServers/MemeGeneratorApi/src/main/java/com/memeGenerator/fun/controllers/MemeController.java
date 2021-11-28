package com.memeGenerator.fun.controllers;

import com.meneGenerator.fun.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MemeController {
    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/uploadImage")
    public boolean uploadImage(@RequestBody MultipartFile file) {
        try {
            storageService.init();
            storageService.store(file);
            return true;
        } catch (Exception e) {
            System.out.println("error " + e);
            return false;
        }
    }

    @GetMapping("/files/{filename}")
	@ResponseBody
	public ResponseEntity serveFile(@PathVariable String filename) {
        try {
            System.out.println("filename"+ filename);
            storageService.init();
            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } catch(Exception e) {
            System.out.println("exception ... " + e);
            return ResponseEntity.ok().header(HttpHeaders.ACCEPT,
            "abc").body("file");
        }
	}

}
