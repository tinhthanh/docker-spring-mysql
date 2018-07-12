package com.pal.intern.config.app;

import com.pal.intern.config.quartz.CacheService;
import com.pal.intern.service.AesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParamConfig {

    @Autowired
    private CacheService configParamRepository;
    @Autowired
    private AesService aesService;

    public String getJwtSecret() {
        String jwtSecretEncrypt = this.configParamRepository.getAllConfigParam().get(ConfigVariable.JWT_SECRET.getName()).toString();
        return this.aesService.decrypt(jwtSecretEncrypt);
    }

    public String getMailServerPassword() {
        String serverPasswordEncrypt = this.configParamRepository.getAllConfigParam().get(ConfigVariable.SERVER_MAIL_PASSWORD.getName()).toString();
        return this.aesService.decrypt(serverPasswordEncrypt);
    }

    public String getRedminePassword() {
        String redminePasswordEncrypt = this.configParamRepository.getAllConfigParam().get(ConfigVariable.REDMINE_PASSWORD.getName()).toString();
        return this.aesService.decrypt(redminePasswordEncrypt);
    }

    public String getRedmineApiKey() {
        String redmineApiKeyEncrypt = this.configParamRepository.getAllConfigParam().get(ConfigVariable.REDMINE_API_KEY.getName()).toString();
        return this.aesService.decrypt(redmineApiKeyEncrypt);
    }

    public String getParamConfig(ConfigVariable e) {
        return this.configParamRepository.getAllConfigParam().get(e.getName()).toString();
    }
}
