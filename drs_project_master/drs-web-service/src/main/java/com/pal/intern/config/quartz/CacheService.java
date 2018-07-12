package com.pal.intern.config.quartz;

import java.util.Map;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface CacheService {

    @Cacheable("param-config")
    public Map<String, Object> getAllConfigParam();

    @CacheEvict(value = "param-config", allEntries = true)
    public void evictCacheForGetAllConfigParam();

}
