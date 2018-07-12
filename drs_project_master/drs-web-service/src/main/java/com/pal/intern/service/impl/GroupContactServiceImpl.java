package com.pal.intern.service.impl;

import com.pal.intern.domain.GroupContact;
import com.pal.intern.mapper.GroupContactQueryStaments;
import com.pal.intern.repository.GroupContactRepository;
import com.pal.intern.service.GroupContactService;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupContactServiceImpl implements GroupContactService {

    @Autowired
    private GroupContactRepository groupContactRepository;

    @Override
    public Optional<GroupContact> getGroupContactByIdAndStatus(int groupContactId, int groupContactStatus) {
        return this.groupContactRepository.getGroupContactByIdAndStatus(groupContactId, groupContactStatus);
    }

    @Override
    public int createGroupContact(String groupContactName, int userId) {
        return this.groupContactRepository.createGroupContact(groupContactName, userId);
    }

    @Override
    public int updateGroupContactById(String groupContactName, int groupContactId) {
        int numberOfRowEffected = 0;
        if (groupContactName != null) {
            numberOfRowEffected += this.groupContactRepository.updateGroupContactContentByAttribute(GroupContactQueryStaments.GROUP_CONTACT_NAME_COL, groupContactName, groupContactId);
        }
        return numberOfRowEffected;
    }

    @Override
    public int deleteGroupContact(int groupContactId) {
        return this.groupContactRepository.updateGroupContactContentByAttribute(GroupContactQueryStaments.GROUP_CONTACT_STATUS_COL, 0, groupContactId);
    }

    @Override
    public Map<String, Object> getAllGroupContactByUserIdWithPaging(int userId, int status, int page, int pageSize) {
        return this.groupContactRepository.getAllGroupContactByUserIdWithPaging(userId, status, page, pageSize);
    }

}
