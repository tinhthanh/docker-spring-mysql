

package com.pal.intern.repository;

import java.util.Map;

public interface ConfigParamRepository {

        public Map<String,Object>getAllConfigParam();
        
        public void evictCache();
}
