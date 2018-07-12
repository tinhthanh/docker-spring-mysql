package com.pal.intern.services;

import com.pal.intern.bean.Privileges;
import com.pal.intern.bean.post.PrivilegesPost;
import java.util.List;

public interface PrivilegesService {

    public List<Privileges> findAllPrivileges(int userId);

    public PrivilegesPost addPrivileges(PrivilegesPost privileges);

    public boolean deletePrivileges(int privilegesId);
    
    public List<Privileges> vierByUser(int userId);
}
