package com.pal.intern.repository;

import com.pal.intern.domain.GroupContactContent;
import java.util.List;
import java.util.Optional;

public interface GroupContactContentRepository {

    public List<GroupContactContent> getGroupContactContentByGroupContactId(int groupContactId, int status);

    public int createGroupContactContent(String contactEmail, int contactAction, int groupContactId);

    public Optional<GroupContactContent> getGroupContactContentById(int groupContactContentId, int status);

    public Optional<GroupContactContent> getGroupContactContentByIdWithAllStatus(int groupContactContentId);

    public int updateGroupContactContent(String contactEmail, int contactAction);

    public int updateGroupContactContentByAttribute(String columnName, Object value, int groupContactId);

    public boolean isGroupContactContentOwner(int groupContactContentId, int userId, int groupContactStatus, int contactContentStatus);
    
    public boolean isGroupContactContentOwner(int groupContactContentId, int userId);

}
