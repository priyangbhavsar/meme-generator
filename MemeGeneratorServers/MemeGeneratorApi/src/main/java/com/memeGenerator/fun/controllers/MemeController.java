package com.memeGenerator.fun.controllers;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.memeGenerator.fun.common.Logger;
import com.memeGenerator.fun.models.UploadImageRequestModel;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MemeController {
    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/uploadImage")
    public ModelAndView uploadImage(@RequestBody UploadImageRequestModel requestModel) {
        MultipartFile file = requestModel.getFile();
        try {
            storageService.init();
            storageService.store(file);
        } catch (Exception e) {
            Logger.debugLog("error " + e);
        }
        return new ModelAndView(
                "redirect:/" + requestModel.getRedirectPath() + "?imageName=" + file.getOriginalFilename());
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity serveFile(@PathVariable String filename) {
        try {
            Logger.debugLog("filename" + filename);
            storageService.init();
            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } catch (Exception e) {
            Logger.debugLog("exception ... " + e);
            return ResponseEntity.ok().header(HttpHeaders.ACCEPT,
                    "abc").body("file");
        }
    }

}
