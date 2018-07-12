package com.pal.intern.config.quartz;

import com.pal.intern.repository.ConfigParamRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImp implements CacheService {

    @Autowired
    private ConfigParamRepository configParamRepository;

    @Override
    public Map<String, Object> getAllConfigParam() {
        return this.configParamRepository.getAllConfigParam();
    }

    @Override
    public void evictCacheForGetAllConfigParam() {

    }

}
