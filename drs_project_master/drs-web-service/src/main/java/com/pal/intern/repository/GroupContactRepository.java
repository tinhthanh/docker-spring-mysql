package com.pal.intern.repository;

import com.pal.intern.domain.GroupContact;
import java.util.Map;
import java.util.Optional;

public interface GroupContactRepository {

    public boolean isGroupContactOwner(int groupContactId, int userId);

    public Optional<GroupContact> getGroupContactByIdAndStatus(int groupContactId, int groupContactStatus);

    public int createGroupContact(String groupContactName, int userId);

    public int updateGroupContactContentByAttribute(String columnName, Object value, int groupContactId);

    public Map<String, Object> getAllGroupContactByUserIdWithPaging(int userId, int status, int page, int pageSize);

    public Map<String, Object> getAllGroupContactByUserIdAndStatusWithPaging(int userId, int status, int page, int pageSize);

}
