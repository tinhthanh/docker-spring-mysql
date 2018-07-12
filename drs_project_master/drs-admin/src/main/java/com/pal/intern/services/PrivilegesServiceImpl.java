package com.pal.intern.services;

import com.pal.intern.bean.Privileges;
import com.pal.intern.bean.post.PrivilegesPost;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pal.intern.dao.PrivilegesDao;

@Service
public class PrivilegesServiceImpl implements PrivilegesService {

    @Autowired
    PrivilegesDao privilegesDao;
    @Autowired
    UserService userService;

    @Override
    public List<Privileges> findAllPrivileges(int userId) {
        return this.privilegesDao.findAllPrivileges(userId);
    }

    @Override
    public PrivilegesPost addPrivileges(PrivilegesPost privileges) {
        privileges.setUserReportName(userService.find(privileges.getUserReportId()).getUserName());
        return this.privilegesDao.addPrivileges(privileges);
    }

    @Override
    public boolean deletePrivileges(int privilegesId) {
        return this.privilegesDao.deletePrivileges(privilegesId);
    }

    @Override
    public List<Privileges> vierByUser(int userId) {
        return this.privilegesDao.vierByUser(userId);
    }

}
