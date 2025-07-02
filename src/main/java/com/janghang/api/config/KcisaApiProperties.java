package com.janghang.api.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kcisa.api")
public class KcisaApiProperties {

    private boolean useExternal;
    private String serviceKey;
    private String externalKeyPath;
    private String baseUrl;
    private String endpoint;

    
    // getters & setters
    public boolean isUseExternal() {
        return useExternal;
    }

    public void setUseExternal(boolean useExternal) {
        this.useExternal = useExternal;
    }
    
    public String getExternalKeyPath() {
        return externalKeyPath;
    }

    public void setExternalKeyPath(String externalKeyPath) {
        this.externalKeyPath = externalKeyPath;
    }
  
    public String getResolvedServiceKey() {
        if (useExternal) {
            try {
                Path path = Paths.get(externalKeyPath);
                return Files.readString(path).trim();
            } catch (IOException e) {
                throw new RuntimeException("🔐 외부 서비스 키 파일 읽기 실패: " + externalKeyPath, e);
            }
        } 
        return serviceKey;
    }
    
    public void setServiceKey(String serviceKey) {
    	this.serviceKey = serviceKey;
    }
    
    public String getBaseUrl() {
    	return baseUrl;
    }
    
    public void setBaseUrl(String baseUrl) {
    	this.baseUrl = baseUrl;
    }
    
    public String getEndpoint() {
    	return endpoint;
    }
    
    public void setEndpoint(String endpoint) {
    	this.endpoint = endpoint;
    }

}