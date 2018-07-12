package com.pal.intern.dao;

import com.pal.intern.bean.Privileges;
import com.pal.intern.bean.post.PrivilegesPost;
import java.util.List;

public interface PrivilegesDao {

    public List<Privileges> findAllPrivileges(int userId);

    public boolean deletePrivileges(int privilegesId);

    public PrivilegesPost addPrivileges(PrivilegesPost privileges);
    
    public List<Privileges> vierByUser(int userId);
    
}
