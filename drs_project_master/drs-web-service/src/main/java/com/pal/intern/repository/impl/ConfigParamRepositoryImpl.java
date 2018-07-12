package com.pal.intern.repository.impl;

import com.pal.intern.mapper.ConfigParamQueryStaments;
import com.pal.intern.repository.ConfigParamRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ConfigParamRepositoryImpl implements ConfigParamRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> getAllConfigParam() {
        String sql = ConfigParamQueryStaments.QUERY_GET_ALL_CONFIG_PARAM;
        Map<String, Object> result = new HashMap<>();
        try {
            List<Map<String, Object>> configs = jdbcTemplate.queryForList(sql);
            if (configs != null) {
                configs.forEach((Map<String, Object> c) -> {
                    result.put(c.get("config_key").toString(), c.get("config_value").toString());
                });
            }
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method getAllConfigParam()", e);
        }
        return result;

    }

    @Override
    public void evictCache() {
        LOGGER.info("cache config param evict");
    }

}
