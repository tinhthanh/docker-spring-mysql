package com.pal.intern.config.redmine;

import com.pal.intern.config.app.ConfigVariable;
import com.pal.intern.config.app.ParamConfig;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "RedmineHTTP")
public class RedmineHTTP implements RedmineManagerProvider {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ParamConfig paramConfig;

    @Override
    public RedmineManager getRedmineManager() {
        LOGGER.info("[connect redmine with] url:" + paramConfig.getParamConfig(ConfigVariable.REDMINE_SERVER_URL) + ", username: " + paramConfig.getParamConfig(ConfigVariable.REDMINE_USERNAME) + " ,password:" + paramConfig.getRedminePassword());
        return RedmineManagerFactory.createWithUserAuth(paramConfig.getParamConfig(ConfigVariable.REDMINE_SERVER_URL), paramConfig.getParamConfig(ConfigVariable.REDMINE_USERNAME), paramConfig.getRedminePassword());
    }

}
