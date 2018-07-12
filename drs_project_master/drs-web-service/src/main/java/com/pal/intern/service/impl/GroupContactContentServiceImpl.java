package com.pal.intern.service.impl;

import com.pal.intern.domain.GroupContactContent;
import com.pal.intern.mapper.GroupContactContentQueryStaments;
import com.pal.intern.repository.GroupContactContentRepository;
import com.pal.intern.service.GroupContactContentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupContactContentServiceImpl implements GroupContactContentService {

    @Autowired
    private GroupContactContentRepository groupContactContentRepository;

    @Override
    public List<GroupContactContent> getGroupContactContentByGroupContactId(int groupContactId, int status) {
        return this.groupContactContentRepository.getGroupContactContentByGroupContactId(groupContactId, status);
    }

    @Override
    public int createGroupContactContent(String contactEmail, int contactAction, int groupContactId) {
        return this.groupContactContentRepository.createGroupContactContent(contactEmail, contactAction, groupContactId);
    }

    @Override
    public Optional<GroupContactContent> getGroupContactContentById(int groupContactContentId, int status) {
        return this.groupContactContentRepository.getGroupContactContentById(groupContactContentId, status);
    }

    @Override
    public int updateGroupContactContent(GroupContactContent groupContactContent) {
        int numRowsEffected = 0;
        if (groupContactContent.getContactAction() == 1 || groupContactContent.getContactAction() == 2) {
            numRowsEffected += this.groupContactContentRepository.updateGroupContactContentByAttribute(GroupContactContentQueryStaments.RECIPIENT_ACTION_COL, groupContactContent.getContactAction(), groupContactContent.getId());
        }
        if (groupContactContent.getContactEmail() != null) {
            numRowsEffected += this.groupContactContentRepository.updateGroupContactContentByAttribute(GroupContactContentQueryStaments.RECIPIENT_EMAIL_COL, groupContactContent.getContactEmail(), groupContactContent.getId());
        }
        return numRowsEffected;
    }

    @Override
    public int deleteGroupContactContet(int groupContactContentId) {
        int numRowsEffected = 0;
        numRowsEffected += this.groupContactContentRepository.updateGroupContactContentByAttribute(GroupContactContentQueryStaments.GROUP_CONTACT_CONTENT_STATUS_COL, 0, groupContactContentId);
        return numRowsEffected;
    }

    @Override
    public Optional<GroupContactContent> getGroupContactContentByIdWithAllStatus(int groupContactContentId) {
        return this.groupContactContentRepository.getGroupContactContentByIdWithAllStatus(groupContactContentId);
    }

}
