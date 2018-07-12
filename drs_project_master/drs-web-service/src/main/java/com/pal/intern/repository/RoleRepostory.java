package com.pal.intern.repository;

import com.pal.intern.domain.Role;
import java.util.List;

public interface RoleRepostory {

    public List<Role> getListRolesByUserId(int userId);

}
