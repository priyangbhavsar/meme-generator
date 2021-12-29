package com.memeGenerator.fun.controllers;

import com.memeGenerator.fun.common.Logger;
import com.memeGenerator.fun.models.MemeListModel;
import com.memeGenerator.fun.models.UploadImageRequestModel;
import com.memeGenerator.fun.service.MemeService;
import com.memeGenerator.fun.service.StorageService;

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
    @Autowired
    private MemeService memeService;

    @PostMapping(value = "/uploadImage")
    public boolean uploadImage(@RequestBody UploadImageRequestModel requestModel) {
        MultipartFile file = requestModel.getFile();
        try {
            storageService.init();
            storageService.store(file);
        } catch (Exception e) {
            Logger.debugLog("error " + e);
        }
        return true;
        // return new ModelAndView(
        //         "redirect:/" + requestModel.getRedirectPath() + "?imageName=" + file.getOriginalFilename());
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Object> serveFile(@PathVariable String filename) {
        try {
            Logger.debugLog("filename" + filename);
            this.storageService.init();
            Resource file = this.storageService.loadAsResource(filename);
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        } catch (Exception e) {
            Logger.debugLog("exception ... " + e);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getMemeList")
    @ResponseBody
    public ResponseEntity<MemeListModel> getMemeList(int pageNumber, int pageSize) {
        MemeListModel response = this.memeService.getMemeList(pageNumber, pageSize);
        return ResponseEntity.ok().body(response);
    }
}
