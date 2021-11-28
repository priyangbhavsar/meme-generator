package com.memeGenerator.fun.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MemeGeneratorConfigurationProperties {
    @Value("${applicationconfigs.uploadfilepath}")
    private String uploadFilePath;

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }
}
