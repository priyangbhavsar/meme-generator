package com.memeGenerator.fun.models;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageRequestModel {

    private MultipartFile file;

    private String redirectPath;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getRedirectPath() {
        return redirectPath;
    }

    public void setRedirectPath(String redirectPath) {
        this.redirectPath = redirectPath;
    }
}
