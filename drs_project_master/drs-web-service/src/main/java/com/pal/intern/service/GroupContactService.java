package com.pal.intern.service;

import com.pal.intern.domain.GroupContact;
import java.util.Map;
import java.util.Optional;

public interface GroupContactService {

    public Optional<GroupContact> getGroupContactByIdAndStatus(int groupContactId, int groupContactStatus);

    public int createGroupContact(String groupContactName, int userId);

    public int updateGroupContactById(String groupContactName, int groupContactId);

    public int deleteGroupContact(int groupContactId);

    public Map<String, Object> getAllGroupContactByUserIdWithPaging(int userId, int status, int page, int pageSize);
}
