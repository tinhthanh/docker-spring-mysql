package com.pal.intern.config.redmine;

import com.pal.intern.config.app.ConfigVariable;
import com.pal.intern.config.app.ParamConfig;
import com.taskadapter.redmineapi.RedmineManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RedmineProviderFactory {
    
    @Autowired
    @Qualifier(value = "RedmineHTTP")
    private RedmineManagerProvider managerProviderHTTP;
    
    @Autowired
    @Qualifier(value = "RedmineAPI")
    private RedmineManagerProvider managerProviderApiKey;
    
    @Autowired
    @Qualifier(value = "RedmineNonAuth")
    private RedmineManagerProvider managerProviderNonAuth;
    
    @Autowired
    private ParamConfig paramConfig;
    
    public RedmineManager getRedmineManager() {
        
        if (paramConfig.getParamConfig(ConfigVariable.REDMINE_SERVER_URL) != null) {
            if (paramConfig.getParamConfig(ConfigVariable.REDMINE_USERNAME) != null && paramConfig.getParamConfig(ConfigVariable.REDMINE_PASSWORD) != null) {
                return managerProviderHTTP.getRedmineManager();
            } else if (paramConfig.getParamConfig(ConfigVariable.REDMINE_API_KEY) != null) {
                return managerProviderApiKey.getRedmineManager();
            } else {
                return managerProviderNonAuth.getRedmineManager();
            }
        }
        return null;
    }
    
}
